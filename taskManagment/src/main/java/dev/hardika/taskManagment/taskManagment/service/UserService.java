package dev.hardika.taskManagment.taskManagment.service;

import dev.hardika.taskManagment.taskManagment.entity.User;
import dev.hardika.taskManagment.taskManagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder password;

    public UserService(UserRepository userRepository, PasswordEncoder password) {
        this.userRepository = userRepository;
        this.password = password;
    }

    public void createUser(User user) {
        user.setPassword(password.encode(user.getPassword()));
        userRepository.save(user);
    }

}
