package dev.hardika.taskManagment.taskManagment.controller;

import dev.hardika.taskManagment.taskManagment.Utility.JwtUtil;
import dev.hardika.taskManagment.taskManagment.request.AuthRequest;
import dev.hardika.taskManagment.taskManagment.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public AuthResponse login(@RequestBody AuthRequest request) {

        // Authenticate the user
        userDetailsService.loadUserByUsername(request.getUserName());

        // Generate the token
        String jwtToken = jwtUtil.generateToken(request.getUserName());

        return new AuthResponse(jwtToken);
    }
}
