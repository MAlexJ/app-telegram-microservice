package com.malexj.model.response;

import com.malexj.model.base.filter.Filter;
import com.malexj.model.base.type.SubscriptionContext;
import com.malexj.model.base.type.SubscriptionType;
import java.time.LocalDateTime;

public record SubscriptionResponse(
    String id,
    Long chatId,
    String templateId,
    SubscriptionType type,
    SubscriptionContext context,
    Filter filter,
    boolean isActive,
    LocalDateTime lastModified,
    LocalDateTime created) {}
