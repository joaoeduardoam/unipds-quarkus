package com.joaoeduardoam;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.eclipse.microprofile.rest.client.inject.*;


@Path("/starwars")
@Produces(MediaType.APPLICATION_JSON)
public class StarWarsResource {

    @RestClient StarWarsService starWarsService;

    @GET
    @Path("starships")
    public String getStarships() {
        return starWarsService.getStarships();
    }

}
