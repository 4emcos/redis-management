package com.four.emcos.redis.management.resources;

import com.four.emcos.redis.management.domain.RedisEntry;
import com.four.emcos.redis.management.service.RedisDeleteService;
import com.four.emcos.redis.management.service.RedisUpdateService;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/update")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public final class RedisUpdateResource {

    private final RedisUpdateService service;

    public RedisUpdateResource(RedisUpdateService service) {
        this.service = service;
    }

    @PATCH
    public Uni<Void> updateById(RedisEntry redisEntry) {
        return service.update(redisEntry.key(), redisEntry.ttl(), redisEntry.value());
    }

}
