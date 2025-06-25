package com.joaoeduardoam;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;


@Path("/unipds")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class UniPDS {

    @GET
    public String hello() {
        return "Hello UniPDS \n";
    }

}
