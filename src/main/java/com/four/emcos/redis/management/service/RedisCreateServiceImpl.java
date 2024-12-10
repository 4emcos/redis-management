package com.four.emcos.redis.management.service;

import com.four.emcos.redis.management.domain.RedisEntry;
import com.four.emcos.redis.management.service.operations.RedisOperationsService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public final class RedisCreateServiceImpl implements RedisCreateService {

    private final RedisOperationsService redisOperationsService;

    public RedisCreateServiceImpl(RedisOperationsService redisOperationsService) {
        this.redisOperationsService = redisOperationsService;
    }

    public Uni<Void> create(RedisEntry redisEntry) {
        return redisOperationsService.set(redisEntry.key(), redisEntry.ttl(), redisEntry.value());
    }

    public Uni<Void> createMany(List<RedisEntry> redisEntries) {
        return Multi.createFrom().iterable(redisEntries)
                .onItem().transformToUni(redisEntry -> redisOperationsService.set(redisEntry.key(), redisEntry.ttl(), redisEntry.value()))
                .concatenate()
                .collect().asList()
                .replaceWithVoid();
    }

}