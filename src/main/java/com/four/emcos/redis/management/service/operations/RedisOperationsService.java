package com.four.emcos.redis.management.service.operations;

import com.four.emcos.redis.management.domain.RedisKeyRes;
import io.smallrye.mutiny.Uni;

import java.util.List;

public sealed interface RedisOperationsService permits RedisOperationsServiceImpl {

    Uni<String> findById(String key);

    Uni<List<RedisKeyRes>> keys();

    Uni<Void> set(String key, Integer ttl, String value);

    Uni<Void> del(String key);

    Uni<Void> delMany(List<String> keys);

    Uni<Void> flush();

    Uni<Void> update(String key, Integer ttl, String value);
}
