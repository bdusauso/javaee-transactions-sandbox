package eu.codinsanity.core.services;

import eu.codinsanity.core.jpa.data.Task;
import eu.codinsanity.core.jpa.data.TaskRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Optional;

@Stateless
public class TaskService {
    @Inject
    private TaskRepository taskRepository;

    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id, Task.class);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}
