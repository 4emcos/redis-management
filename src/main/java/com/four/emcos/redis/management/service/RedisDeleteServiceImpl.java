package com.four.emcos.redis.management.service;

import com.four.emcos.redis.management.domain.RedisKeyRes;
import com.four.emcos.redis.management.service.operations.RedisOperationsService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public final class RedisDeleteServiceImpl implements RedisDeleteService {

    private final RedisOperationsService redisOperationsService;

    public RedisDeleteServiceImpl(RedisOperationsService redisOperationsService) {
        this.redisOperationsService = redisOperationsService;
    }

    public Uni<Void> delete(String id) {
        return redisOperationsService.del(id);
    }

    public Uni<Void> deleteMany(List<String> ids) {
        return redisOperationsService.delMany(ids);
    }
    public Uni<Void> flush() {
        return redisOperationsService.flush();
    }
}