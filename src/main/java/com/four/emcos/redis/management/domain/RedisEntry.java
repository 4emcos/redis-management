package com.four.emcos.redis.management.domain;

import jakarta.annotation.Nullable;

public record RedisEntry(
        String key,
        String value,
        @Nullable
        Integer ttl
) {
}
