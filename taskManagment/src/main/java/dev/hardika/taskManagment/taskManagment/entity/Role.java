package dev.hardika.taskManagment.taskManagment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "user-role")

public class Role {
    @Id
    private long id;
    private String roleName;
    private String description;
}
