package dev.hardika.taskManagment.taskManagment.repository;

import dev.hardika.taskManagment.taskManagment.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    List<Task> findByStatusAndUserId(String status, Long userId);
    List<Task> findByPriorityAndUserId(String priority, Long userId);
    List<Task> findByDueDateAndUserId(LocalDateTime dueDate, Long userId);
    List<Task> findByTitleContainingOrDescriptionContainingAndUserId(String title, String description, Long userId);
    List<Task> findByTitleContaining(String title);
    List<Task> findByDescriptionContaining(String description);
}
