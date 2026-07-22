package com.example.taskmanagementapi.service;

import com.example.taskmanagementapi.model.Priority;
import com.example.taskmanagementapi.model.Task;
import com.example.taskmanagementapi.repository.TaskRepository;
import com.example.taskmanagementapi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final AIService aiService;

    public TaskService(TaskRepository repository, AIService aiService) {
        this.repository = repository;
        this.aiService = aiService;
    }

    public List<Task> getAll() {
        return repository.findAll();
    }

    public List<Task> getByPriority(Priority priority) {
        return repository.findByPriority(priority);
    }

    public Task getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    public Task create(Task task) {

        if (task.getPriority() == null) {
            Priority suggestedPriority =
                    aiService.suggestPriority(task.getTitle());

            task.setPriority(suggestedPriority);
        }

        return repository.save(task);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public Task update(Long id, Task task) {
        Task existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        existing.setTitle(task.getTitle());
        existing.setCompleted(task.isCompleted());
        existing.setPriority(task.getPriority());
        existing.setDueDate(task.getDueDate());

        return repository.save(existing);
    }
}