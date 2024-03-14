package com.malexj.model.http.response;

import com.malexj.model.filter.Filter;
import com.malexj.model.type.SubscriptionContext;
import com.malexj.model.type.SubscriptionType;
import java.time.LocalDateTime;

public record SubscriptionResponse(
    Long chatId,
    Long templateId,
    SubscriptionType type,
    SubscriptionContext context,
    Filter filter,
    boolean isActive,
    LocalDateTime lastModified,
    LocalDateTime created) {}
