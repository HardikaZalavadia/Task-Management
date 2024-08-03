package dev.hardika.taskManagment.taskManagment.request;

import dev.hardika.taskManagment.taskManagment.entity.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {
    private String title;
    private String description;
    private TaskStatus status;
    private String priority;
    private long userId;
}
