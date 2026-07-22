package com.example.taskmanagementapi.repository;

import com.example.taskmanagementapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.taskmanagementapi.model.Priority;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByPriority(Priority priority);
}