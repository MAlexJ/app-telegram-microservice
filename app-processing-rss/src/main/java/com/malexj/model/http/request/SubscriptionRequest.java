package com.malexj.model.http.request;

import com.malexj.model.type.SubscriptionType;

public record SubscriptionRequest(SubscriptionType type, boolean isActive) {

  public SubscriptionRequest() {
    this(SubscriptionType.RSS, true);
  }
}
