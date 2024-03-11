package com.malexj.service;

import com.malexj.mapper.ObjectMapper;
import com.malexj.model.request.SubscriptionRequest;
import com.malexj.model.response.SubscriptionResponse;
import com.malexj.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionService {

  private final ObjectMapper mapper;
  private final SubscriptionRepository repository;

  public Flux<SubscriptionResponse> findAll() {
    return repository.findAll().map(mapper::entityToResponse);
  }

  public Mono<SubscriptionResponse> createSubscription(SubscriptionRequest request) {
    return Mono.fromSupplier(() -> mapper.requestToEntity(request))
        .flatMap(repository::save)
        .map(mapper::entityToResponse);
  }

  public Mono<Long> updateSubscription(String id) {
    return repository
        .updateSubscriptionEntity(id)
        .doOnNext(resp -> log.info("Records updated - {}", resp));
  }
}
