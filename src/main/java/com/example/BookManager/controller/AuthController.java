package com.example.BookManager.controller;

import com.example.BookManager.dto.requests.AuthUserRequest;
import com.example.BookManager.entity.users;
import com.example.BookManager.service.AuthService;
import com.example.BookManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

    @PostMapping()
    String AuthUser(@RequestBody AuthUserRequest request)
    {
        users user = userService.findUserByUserName(request.getUsername());
        if(request.getPassword().contains(user.getPasswordHash()))
            return "Login successfully";
        return "Login failed";
    }
}
