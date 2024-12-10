package com.four.emcos.redis.management.resources;

import com.four.emcos.redis.management.domain.RedisKeyRes;
import com.four.emcos.redis.management.service.RedisReadService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/keys")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public final class RedisReadResource{

    private final RedisReadService service;

    public RedisReadResource(RedisReadService service) {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    public Uni<String> findById(@PathParam("id") String id) {
        return service.findById(id);
    }

    @GET
    public Uni<List<RedisKeyRes>> findAll() {
        return service.findAll();
    }
}
