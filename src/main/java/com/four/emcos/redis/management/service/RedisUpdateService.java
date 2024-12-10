package com.four.emcos.redis.management.service;

import io.smallrye.mutiny.Uni;

import java.util.List;

public sealed interface RedisUpdateService permits RedisUpdateServiceImpl {

    Uni<Void> update(String key, Integer ttl, String value);
}