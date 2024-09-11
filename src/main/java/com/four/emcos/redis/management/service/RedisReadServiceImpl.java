package com.four.emcos.redis.management.service;

import com.four.emcos.redis.management.service.operations.RedisOperationsService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.LoggerFactory;
import org. slf4j. Logger;

import java.util.List;

@ApplicationScoped
public final class RedisReadServiceImpl implements RedisReadService {

    @Inject
    RedisOperationsService redisOperationsService;

    private static final Logger log = LoggerFactory.getLogger(RedisReadServiceImpl.class);

    public String findById(String id) {
        return redisOperationsService.findById(id);
    }

    public Uni<List<String>> findAll() {
        return redisOperationsService.keys();
    }
}