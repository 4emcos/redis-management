package com.four.emcos.redis.management.service;

import io.smallrye.mutiny.Uni;

import java.util.List;

public sealed interface RedisOperationsService permits RedisOperationsServiceImpl {

    String get(String key);

    void set(String key, String value);

    Uni<Void> del(String key);

    Uni<List<String>> keys();
}
