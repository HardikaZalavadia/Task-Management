package dev.hardika.taskManagment.taskManagment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    private String userName;
    private String password;
}
