package com.joaoeduardoam;

import org.eclipse.microprofile.health.*;

@Liveness
public class LivenessCheck implements HealthCheck{ //  Don't name the class with "Liveness"
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("LIVENESS OK");
    }


}
