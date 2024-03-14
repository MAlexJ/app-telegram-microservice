package com.malexj.repository;

import com.malexj.model.entity.TopicEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends ReactiveMongoRepository<TopicEntity, String> {}
