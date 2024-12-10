package com.four.emcos.redis.management.service;

import com.four.emcos.redis.management.domain.RedisKeyRes;
import io.smallrye.mutiny.Uni;

import java.util.List;

public sealed interface RedisDeleteService permits RedisDeleteServiceImpl {

    Uni<Void> delete(String id);

    Uni<Void> deleteMany(List<String> ids);

    Uni<Void> flush();

}