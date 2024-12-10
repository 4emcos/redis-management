package com.four.emcos.redis.management.service;

import com.four.emcos.redis.management.domain.RedisKeyRes;
import io.smallrye.mutiny.Uni;

import java.util.List;

public sealed interface RedisReadService permits RedisReadServiceImpl {

    Uni<String> findById(String id);

    Uni<List<RedisKeyRes>> findAll();
}