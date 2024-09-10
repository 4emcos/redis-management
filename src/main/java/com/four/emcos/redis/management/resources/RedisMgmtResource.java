package com.four.emcos.redis.management.resources;

import com.four.emcos.redis.management.domain.Increment;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/keys")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
sealed interface RedisMgmtResource permits RedisMgmtResourceImpl {

    @GET
    @Path("/find")
    String findById(@QueryParam("id") String id);

    @GET
    Uni<List<String>> findAll();

    @POST
    Increment create(Increment increment);

}
