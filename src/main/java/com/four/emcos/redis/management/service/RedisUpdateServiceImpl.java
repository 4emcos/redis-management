package com.four.emcos.redis.management.service;

import com.four.emcos.redis.management.service.operations.RedisOperationsService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public final class RedisUpdateServiceImpl implements RedisUpdateService {

    private final RedisOperationsService redisOperationsService;

    public RedisUpdateServiceImpl(RedisOperationsService redisOperationsService) {
        this.redisOperationsService = redisOperationsService;
    }

   public  Uni<Void> update(String key, Integer ttl, String value) {
        return redisOperationsService.update(key, ttl, value);
    }
}