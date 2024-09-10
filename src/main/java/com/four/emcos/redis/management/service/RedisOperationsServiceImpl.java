package com.four.emcos.redis.management.service;

import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.value.ValueCommands;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public final class RedisOperationsServiceImpl implements RedisOperationsService {

    private final ReactiveKeyCommands<String> keyCommands;
    private final ValueCommands<String, String> valueCommands;

    public RedisOperationsServiceImpl(RedisDataSource ds, ReactiveRedisDataSource reactive) {
        this.valueCommands = ds.value(String.class);
        this.keyCommands = reactive.key();
    }

    @Override
    public String get(String key) {
        return valueCommands.get(key);
    }

    @Override
    public void set(String key, String value) {
        valueCommands.set(key, value);
    }

    @Override
    public Uni<Void> del(String key) {
        return keyCommands.del(key).replaceWithVoid();
    }

    @Override
    public Uni<List<String>> keys() {
        return keyCommands.keys("*");
    }
}
