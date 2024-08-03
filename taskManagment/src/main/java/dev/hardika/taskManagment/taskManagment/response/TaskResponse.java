package dev.hardika.taskManagment.taskManagment.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponse {
    private long id;
    private String name;
    private String description;
    private long userId;
}
