package com.malexj.repository;

import com.malexj.model.entity.SubscriptionEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SubscriptionRepository
    extends ReactiveMongoRepository<SubscriptionEntity, String> {

  @Query("{'id': ?0 }")
  @Update(update = "{ $set: { isActive : false }}")
  Mono<Long> updateSubscriptionEntity(String id);
}
