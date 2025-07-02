package com.joaoeduardoam;


import jakarta.annotation.security.*;
import jakarta.enterprise.context.*;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.jwt.*;

@Path("/secure")
@RequestScoped
public class SecureResource {

    @Claim(standard = Claims.preferred_username)
    private  String username;


    // curl -v -w '\n' -H "Authorization: Bearer $token" localhost:8080/api/secure/claim
    @GET
    @Path("claim")
    @RolesAllowed("Subscriber")
    // @RolesAllowed("Not-Subscriber")
    public String getClaims(){
        return username;
    }



}
