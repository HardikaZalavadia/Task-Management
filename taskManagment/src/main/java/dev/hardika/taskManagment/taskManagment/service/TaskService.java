package dev.hardika.taskManagment.taskManagment.service;


import dev.hardika.taskManagment.taskManagment.entity.Task;
import dev.hardika.taskManagment.taskManagment.repository.TaskRepository;
import dev.hardika.taskManagment.taskManagment.request.TaskRequest;
import dev.hardika.taskManagment.taskManagment.response.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public TaskResponse createTask(TaskRequest task){
        Task taskEntity = new Task();
        taskEntity.setDescription(task.getDescription());
        taskEntity.setPriority(task.getPriority());
        taskEntity.setStatus(task.getStatus());
        taskEntity.setTitle(task.getTitle());
        taskEntity.getUser().setId(task.getUserId());

        taskRepository.save(taskEntity);
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(taskEntity.getId());
        taskResponse.setDescription(taskEntity.getDescription());
        taskResponse.setName(taskEntity.getTitle());
        taskResponse.setUserId(taskEntity.getUser().getId());
        return taskResponse;
    }

    public List<TaskResponse> getAllTasks(){
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponse> taskResponses = new ArrayList<>();
        for(Task task : tasks){
            TaskResponse taskResponse = new TaskResponse();
            taskResponse.setId(task.getId());
            taskResponse.setDescription(task.getDescription());
            taskResponse.setName(task.getTitle());
            taskResponse.setUserId(task.getUser().getId());
            taskResponses.add(taskResponse);
        }
        return taskResponses;
    }

    public TaskResponse updateTask(long id, TaskRequest task){
        Task task1 = taskRepository.findById(id).get();
        task1.setTitle(task.getTitle());
        task1.setDescription(task.getDescription());
        task1.setPriority(task.getPriority());
        task1.setStatus(task.getStatus());
        task1.getUser().setId(task.getUserId());

        taskRepository.save(task1);

        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task1.getId());
        taskResponse.setDescription(task1.getDescription());
        taskResponse.setName(task1.getTitle());
        taskResponse.setUserId(task1.getUser().getId());
        return taskResponse;
    }

    public void deleteTask(long id){
        taskRepository.deleteById(id);
    }

    public List<Task> searchTasks(Long userId, String query) {
        return taskRepository.findByTitleContainingOrDescriptionContainingAndUserId(query, query, userId);
    }


    public List<Task> filterTasks(Long userId, String status, String priority, LocalDateTime dueDate) {
        if (status != null && !status.isEmpty()) {
            return taskRepository.findByStatusAndUserId(status, userId);
        } else if (priority != null && !priority.isEmpty()) {
            return taskRepository.findByPriorityAndUserId(priority, userId);
        } else if (dueDate != null) {
            return taskRepository.findByDueDateAndUserId(dueDate, userId);
        } else {
            return taskRepository.findByUserId(userId);
        }
    }
}
