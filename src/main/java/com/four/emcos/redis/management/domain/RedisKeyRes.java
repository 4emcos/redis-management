package com.four.emcos.redis.management.domain;

public record RedisKeyRes(
        String key,
        String decodedKey,
        String ttl
) {
}
