package com.joaoeduardoam;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.eclipse.microprofile.rest.client.inject.*;


@RegisterRestClient(baseUri = "https://swapi.info/api/")
public interface StarWarsService{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("starships")
    public String getStarships();
}
