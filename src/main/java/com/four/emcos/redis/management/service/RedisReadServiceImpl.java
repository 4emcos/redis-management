package com.four.emcos.redis.management.service;

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

    // TODO: need to impl
    public String findById(String id) {
        log.info("Finding by ID: " + id);
        return id;
    }

    // TODO: need to impl
    public Uni<List<String>> findAll() {
        log.info("Finding all keys");
        return redisOperationsService.keys();
    }
}