package dev.hardika.taskManagment.taskManagment.controller;

import dev.hardika.taskManagment.taskManagment.entity.User;
import dev.hardika.taskManagment.taskManagment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String userRegister(@RequestBody User user) {
        userService.createUser(user);
        return "User created";
    }

}
