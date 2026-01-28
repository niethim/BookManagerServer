package com.example.BookManager.service;

import com.example.BookManager.dto.requests.AuthUserRequest;
import com.example.BookManager.entity.users;
import com.example.BookManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public boolean AuthUser(@RequestBody AuthUserRequest request)
    {
        users foundUser= userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return foundUser.getPasswordHash().contains(request.getPassword());
    }

}
