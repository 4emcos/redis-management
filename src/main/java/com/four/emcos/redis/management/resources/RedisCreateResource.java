package com.four.emcos.redis.management.resources;

import com.four.emcos.redis.management.domain.RedisEntry;
import com.four.emcos.redis.management.service.RedisCreateService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/create")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public final class RedisCreateResource {

    @Inject
    RedisCreateService service;

    @POST
    public RedisEntry create(RedisEntry redisEntry) {
        service.create(redisEntry);
        return redisEntry;
    }
}
