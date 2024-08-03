package dev.hardika.taskManagment.taskManagment.controller;

import dev.hardika.taskManagment.taskManagment.entity.Task;
import dev.hardika.taskManagment.taskManagment.request.TaskRequest;
import dev.hardika.taskManagment.taskManagment.response.TaskResponse;
import dev.hardika.taskManagment.taskManagment.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable("id") long id,@RequestBody TaskRequest task) {
            return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
