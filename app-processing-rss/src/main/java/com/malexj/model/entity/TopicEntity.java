package com.malexj.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.malexj.model.filter.Filter;
import com.malexj.model.type.SubscriptionContext;
import com.malexj.model.type.SubscriptionType;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "topics")
@TypeAlias("TopicEntity")
public class TopicEntity implements Persistable<String> {
  @MongoId private String id;
  private Long chatId;
  private String subscriptionId;
  private SubscriptionType type;
  private SubscriptionContext context;
  private Filter filter;
  private String title;
  private String description;
  private String link;

  /**
   * Spring Data: Unique field in MongoDB document
   *
   * <p>link: <a
   * href="https://stackoverflow.com/questions/49385130/spring-data-unique-field-in-mongodb-document">Unique
   * field in MongoDB</a> <br>
   * 1. spring.data.mongodb.auto-index-creation=true <br>
   * 2. but you have to delete your database and then re-run your application
   */
  @Indexed(unique = true)
  private String md5Hash;

  private boolean isActive;
  @CreatedDate private LocalDateTime created;

  @Override
  @JsonIgnore
  public boolean isNew() {
    return Objects.isNull(getCreated());
  }
}