package com.four.emcos.redis.management.service;

import io.smallrye.mutiny.Uni;

import java.util.List;

public sealed interface RedisReadService permits RedisReadServiceImpl {

    String findById(String id);

    Uni<List<String>> findAll();
}