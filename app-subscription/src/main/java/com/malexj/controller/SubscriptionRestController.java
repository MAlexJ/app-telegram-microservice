package com.malexj.controller;

import com.malexj.mapper.ObjectMapper;
import com.malexj.model.entity.SubscriptionEntity;
import com.malexj.model.request.SubscriptionRequest;
import com.malexj.model.response.SubscriptionResponse;
import com.malexj.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * WebFlux supports using a single value reactive type to produce the ResponseEntity asynchronously,
 * and/or single and multi-value reactive types for the body. <br>
 * This allows a variety of async responses with ResponseEntity as follows:
 *
 * <ul>
 *   <li>ResponseEntity<Mono<T>> or ResponseEntity<Flux<T>> make the response status and headers
 *       known immediately while the body is provided asynchronously at a later point. Use Mono if
 *       the body consists of 0..1 values or Flux if it can produce multiple values.
 *   <li>Mono<ResponseEntity<T>> provides all three — response status, headers, and body,
 *       asynchronously at a later point. This allows the response status and headers to vary
 *       depending on the outcome of asynchronous request handling.
 *   <li>Mono<ResponseEntity<Mono<T>>> or Mono<ResponseEntity<Flux<T>>> are yet another possible,
 *       albeit less common alternative. They provide the response status and headers asynchronously
 *       first and then the response body, also asynchronously, second.
 * </ul>
 *
 * Link to info: <a
 * href="https://docs.spring.io/spring-framework/reference/web/webflux/controller/ann-methods/responseentity.html">ResponseEntity</a>
 */
@RestController
@RequestMapping("/v1/subscription")
@RequiredArgsConstructor
public class SubscriptionRestController {

  private final ObjectMapper mapper;
  private final SubscriptionRepository repository;

  @GetMapping
  public ResponseEntity<Flux<SubscriptionEntity>> findAllSubscriptions() {
    Flux<SubscriptionEntity> subscriptions = repository.findAll();
    return ResponseEntity.ok(subscriptions);
  }

  @PostMapping
  public ResponseEntity<Mono<SubscriptionResponse>> createSubscription(
      @RequestBody SubscriptionRequest request) {
    Mono<SubscriptionResponse> response =
        Mono.fromSupplier(() -> mapper.requestToEntity(request))
            .flatMap(repository::save)
            .map(mapper::entityToResponse);
    return ResponseEntity.ok(response);
  }

  @PatchMapping("/{id}")
  public Mono<ResponseEntity<Void>> unsubscribe(@PathVariable String id) {
    return repository
        .updateSubscriptionEntity(id)
        .map(resp -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
  }
}
