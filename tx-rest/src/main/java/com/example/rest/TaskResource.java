package com.example.rest;

import com.example.ejb.TaskService;
import com.example.jpa.TaskEntity;
import com.example.jpa.TaskStatus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("tasks")
public class TaskResource {

    @Inject
    private TaskService taskService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTask(@PathParam("id") Long id) {
        return taskService.getTask(id)
                          .map(taskEntity -> Response.ok(taskEntity).build())
                          .orElse(Response.status(404).build());
    }

    @POST
    @Path("/")
    public Response createAndRaiseTask() {
        TaskEntity task = new TaskEntity("Foo", TaskStatus.RUNNING);
        task = taskService.saveTask(task);

        return Response.ok(task).build();
    }
}
