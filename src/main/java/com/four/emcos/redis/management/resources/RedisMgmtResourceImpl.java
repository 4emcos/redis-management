package com.four.emcos.redis.management.resources;

import com.four.emcos.redis.management.domain.Increment;
import com.four.emcos.redis.management.service.RedisReadService;
import com.four.emcos.redis.management.service.RedisOperationsService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;

import java.util.List;

public final class RedisMgmtResourceImpl implements RedisMgmtResource {

    @Inject
    RedisReadService redisReadService;

    @Inject
    RedisOperationsService service;

    @Override
    public String findById(String id) {
        return redisReadService.findById(id);
    }

    @Override
    public Uni<List<String>> findAll() {
        return redisReadService.findAll();
    }

    // TODO: need to create in other context
    public Increment create(Increment increment) {
        service.set(increment.key(), increment.value());
        return increment;
    }
}
