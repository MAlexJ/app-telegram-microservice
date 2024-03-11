package com.malexj.model.response;

import com.malexj.model.filter.Filter;
import java.time.LocalDateTime;

public record SubscriptionResponse(
    String id,
    Long chatId,
    Long templateId,
    String url,
    Filter filter,
    boolean isActive,
    LocalDateTime lastModified,
    LocalDateTime created) {}
