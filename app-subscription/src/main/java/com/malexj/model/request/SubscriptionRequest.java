package com.malexj.model.request;

import com.malexj.model.filter.Filter;

public record SubscriptionRequest(
    Long chatId, Long templateId, String url, Filter filter, boolean isActive) {}
