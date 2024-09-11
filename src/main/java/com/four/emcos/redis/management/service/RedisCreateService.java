package com.four.emcos.redis.management.service;

import com.four.emcos.redis.management.domain.RedisEntry;

public sealed interface RedisCreateService permits RedisCreateServiceImpl {
    RedisEntry create(RedisEntry redisEntry);
}