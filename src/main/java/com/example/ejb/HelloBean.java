package com.example.ejb;

import com.example.jpa.TaskEntity;
import com.example.jpa.TaskRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class HelloBean {
    @Inject
    private TaskRepository taskRepository;

    public TaskEntity getTask(Long id) {
        return taskRepository.findById(id, TaskEntity.class);
    }
}
