package com.four.emcos.redis.management.resources;

import com.four.emcos.redis.management.domain.RedisKeyRes;
import com.four.emcos.redis.management.service.RedisDeleteService;
import com.four.emcos.redis.management.service.RedisReadService;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/delete")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public final class RedisDeleteResource {

    private final RedisDeleteService service;

    public RedisDeleteResource(RedisDeleteService service) {
        this.service = service;
    }

    @DELETE
    @Path("/{id}")
    public Uni<Void> deleteById(@PathParam("id") String id) {
        return service.delete(id);
    }

    @POST
    @Path("/many")
    public Uni<Void> deleteMany(List<String> ids) {
        return service.deleteMany(ids);
    }

    @DELETE
    @Path("/all")
    public Uni<Void> flush() {
        return service.flush();
    }


}
