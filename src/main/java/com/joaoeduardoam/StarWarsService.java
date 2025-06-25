package com.joaoeduardoam;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.eclipse.microprofile.faulttolerance.*;
import org.eclipse.microprofile.rest.client.inject.*;


@RegisterRestClient(baseUri = "https://swapi.info/api/")
public interface StarWarsService{

    public static final String MSG_ERROR = "Fallback";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("starships")
    @Timeout(value = 3000L)
    @Fallback(
            fallbackMethod = "getStarshipsFallback"
    )
    @CircuitBreaker(
            requestVolumeThreshold = 2,
            failureRatio = .5,
            delay = 3000L,
            successThreshold = 2
    )
    public String getStarships();

    default String getStarshipsFallback(){ //Must have the same signature (return type and parameters) as the calling method
        return MSG_ERROR;
    }
}
