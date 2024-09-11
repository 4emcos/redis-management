package com.four.emcos.redis.management.resources;

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

    @Inject
    RedisReadService service;

    @GET
    @Path("/{id}")
    public String findById(@PathParam("id") String id) {
        return service.findById(id);
    }

    @GET
    public Uni<List<String>> findAll() {
        return service.findAll();
    }
}
