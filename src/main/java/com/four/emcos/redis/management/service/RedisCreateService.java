package com.four.emcos.redis.management.service;

import com.four.emcos.redis.management.domain.RedisEntry;
import io.smallrye.mutiny.Uni;

import java.util.List;

public sealed interface RedisCreateService permits RedisCreateServiceImpl {

    Uni<Void> create(RedisEntry redisEntry);

    Uni<Void> createMany(List<RedisEntry> redisEntries);
}