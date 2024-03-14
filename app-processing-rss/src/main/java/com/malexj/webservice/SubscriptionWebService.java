package com.malexj.webservice;

import com.malexj.model.http.ResponseState;
import com.malexj.model.http.request.SubscriptionRequest;
import com.malexj.model.http.response.SubscriptionResponse;
import com.netflix.discovery.EurekaClient;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionWebService {

  private final WebClient webClient;

  @Lazy private final EurekaClient eurekaClient;

  @Value("${app-subscription-service.endpoint.get.subscriptions}")
  private String endpoint;

  @Value("${app-subscription-service.application.name}")
  private String virtualHostname;

  public Flux<SubscriptionResponse> fetchAllActiveRssSubscriptions(SubscriptionRequest request) {
    URI serviceUri = buildServiceUri(endpoint, request);
    return webClient
        .get()
        .uri(serviceUri)
        .retrieve()
        .bodyToFlux(SubscriptionResponse.class)
        .doOnNext(
            response ->
                log.info("HTTP state - {}, response - {}", ResponseState.SERVICE, response));
  }

  private URI buildServiceUri(String path, SubscriptionRequest request) {
    // add to path: ?type=RSS&active=true
    var type = request.type();
    var active = request.isActive();
    return UriComponentsBuilder.fromUriString(discoveryServiceUrl(virtualHostname))
        .path(path)
        .build()
        .toUri();
  }

  private String discoveryServiceUrl(String virtualHostname) {
    var instance = eurekaClient.getNextServerFromEureka(virtualHostname, false);
    return instance.getHomePageUrl();
  }
}
