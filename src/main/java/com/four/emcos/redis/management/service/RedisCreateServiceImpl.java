package com.four.emcos.redis.management.service;

import com.four.emcos.redis.management.domain.RedisEntry;
import com.four.emcos.redis.management.service.operations.RedisOperationsService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public final class RedisCreateServiceImpl implements RedisCreateService {

    @Inject
    RedisOperationsService redisOperationsService;

    public RedisEntry create(RedisEntry redisEntry) {
        redisOperationsService.set(redisEntry.key(), redisEntry.value());
        return redisEntry;
    }
}