package com.example.rest;

import com.example.ejb.TaskService;
import com.example.jpa.TaskEntity;
import com.example.jpa.TaskStatus;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloResource {

    @Inject
    private TaskService taskService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello() {
        TaskEntity task = taskService.getTask(1L);
        return Response.ok(task).build();
    }

    @POST
    @Path("/")
    public Response createAndRaiseTask() {
        TaskEntity task = new TaskEntity("Foo", TaskStatus.RUNNING);
        task = taskService.saveTask(task);

        return Response.ok(task).build();
    }
}
