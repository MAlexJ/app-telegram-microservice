package com.malexj.controller;

import com.malexj.model.http.request.RssRequest;
import com.malexj.model.http.response.RssResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * WebFlux supports using a single value reactive type to produce the ResponseEntity asynchronously,
 * and/or single and multi-value reactive types for the body. This allows a variety of async
 * responses with ResponseEntity as follows:
 *
 * <ul>
 *   <li>ResponseEntity<Mono<T>> or ResponseEntity<Flux<T>> make the response status and headers
 *       known immediately while the body is provided asynchronously at a later point. Use Mono if
 *       the body consists of 0..1 values or Flux if it can produce multiple values.
 *   <li>Mono<ResponseEntity<T>> provides all three: response status, headers, and body,
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
@Slf4j
@RestController
@RequestMapping("/v1")
public class RssRestController {

  @PostMapping("/rss")
  public ResponseEntity<Mono<RssResponse>> findRssItemsByUrl(@RequestBody RssRequest request) {
    log.trace("Rss request - {}", request);
    return ResponseEntity.ok(Mono.empty());
  }

//  @GetMapping("/rss/topics")
//  public ResponseEntity<Void> findAllRssTopics() {
//    return ResponseEntity.ok().build();
//  }
}
