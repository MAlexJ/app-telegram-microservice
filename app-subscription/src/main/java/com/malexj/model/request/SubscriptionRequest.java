package com.malexj.model.request;

import com.malexj.model.base.filter.Filter;
import com.malexj.model.base.type.SubscriptionContext;
import com.malexj.model.base.type.SubscriptionType;

public record SubscriptionRequest(
    Long chatId,
    String templateId,
    SubscriptionType type,
    SubscriptionContext context,
    Filter filter,
    boolean isActive) {}
