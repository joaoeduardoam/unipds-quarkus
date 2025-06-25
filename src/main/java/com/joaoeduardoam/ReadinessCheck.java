package com.joaoeduardoam;

import org.eclipse.microprofile.health.*;
import org.eclipse.microprofile.rest.client.inject.*;

@Readiness
public class ReadinessCheck implements HealthCheck{ //  Don't name the class with "Liveness"

    @RestClient
    StarWarsService starWarsService;

    @Override
    public HealthCheckResponse call() {

        if(starWarsService.getStarships().contains(StarWarsService.MSG_ERROR)){
            return HealthCheckResponse.down("READINESS ERROR");
        }else {
            return HealthCheckResponse.up("READINESS OK");
        }

    }


}
