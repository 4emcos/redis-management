package com.four.emcos.redis.management.service.operations;

import com.four.emcos.redis.management.domain.RedisKeyRes;
import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.value.ReactiveValueCommands;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

import static com.four.emcos.redis.management.utils.Utils.determineTtl;

@ApplicationScoped
public final class RedisOperationsServiceImpl implements RedisOperationsService {

    private final ReactiveKeyCommands<String> keyCommands;
    private final ReactiveValueCommands<String, String> valueCommands;

    public RedisOperationsServiceImpl(ReactiveRedisDataSource reactive) {
        this.valueCommands = reactive.value(String.class, String.class);
        this.keyCommands = reactive.key();
    }

    @Override
    public Uni<String> findById(String key) {
        return valueCommands.get(key);
    }

    @Override
    public Uni<Void> set(String key, Integer ttl, String value) {
        if (ttl == null) {
            return valueCommands.set(key, value).replaceWithVoid();
        } else {
            return valueCommands.setex(key, ttl, value).replaceWithVoid();
        }
    }

    @Override
    public Uni<Void> del(String key) {
        return keyCommands.del(key).replaceWithVoid();
    }

    @Override
    public Uni<Void> delMany(List<String> keys) {
        return Multi.createFrom().iterable(keys)
                .onItem().transformToUni(key -> keyCommands.del(key).replaceWithVoid())
                .concatenate()
                .collect().asList()
                .replaceWithVoid()
                .onFailure().recoverWithUni(Uni.createFrom().voidItem());
    }

    @Override
    public Uni<Void> flush() {
        return keyCommands.getDataSource().flushall();
    }

    @Override
    public Uni<Void> update(String key, Integer ttl, String value) {
        return del(key).onItem().transformToUni(v -> set(key, ttl, value));
    }

    @Override
    public Uni<List<RedisKeyRes>> keys() {
        return keyCommands.keys("*")
                .onItem().transformToUni(keys ->
                        Multi.createFrom().iterable(keys)
                                .onItem().transformToUni(key ->
                                        ttlById(key).onItem().transform(ttl ->
                                                new RedisKeyRes(
                                                        key,
                                                        key,
                                                        determineTtl(ttl)
                                                )
                                        )
                                ).concatenate()
                                .collect().asList()
                );
    }

    private Uni<Long> ttlById(String key) {
        return keyCommands.ttl(key);
    }
}
