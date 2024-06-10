package com.example.rest;

import com.example.ejb.HelloBean;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloResource {

    @Inject
    private HelloBean helloBean;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello() {
        return Response.ok(helloBean.getTask(1L)).build();
    }
}
