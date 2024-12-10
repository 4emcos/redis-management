package com.four.emcos.redis.management.resources;

import com.four.emcos.redis.management.domain.RedisEntry;
import com.four.emcos.redis.management.service.RedisCreateService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/create")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public final class RedisCreateResource {

    private final RedisCreateService service;

    public RedisCreateResource(RedisCreateService service) {
        this.service = service;
    }

    @POST
    public Uni<Void> create(RedisEntry redisEntry) {
        return service.create(redisEntry);
    }

    @POST
    @Path("/many")
    public Uni<Void> createMany(List<RedisEntry> redisEntries) {
        return service.createMany(redisEntries);
    }
}
