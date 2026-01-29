package com.example.BookManager.service.user;

import com.example.BookManager.dto.requests.CreateUserRequest;
import com.example.BookManager.entity.users;
import com.example.BookManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public users findUserByUserName(String Username)
    {
        return userRepository.findByUsername(Username)
                .orElseThrow(() -> new RuntimeException("User not founded"));
    }

    public users createUser(CreateUserRequest request)
    {
        users newUser = new users();
        newUser.setRole(request.getRole());
        newUser.setUsername(request.getUsername());
        newUser.setPasswordHash(request.getPasswordHash());
        return userRepository.save(newUser);
    }
    public List<users> readUsers()
    {
        return userRepository.findAll();
    }

    public users findUserByUserID(Long Id)
    {
        return userRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("User not founded"));
    }
    public long getNumberOfRegisteredUser()
    {
        return userRepository.getNumberOfRegisteredUser();
    }
}
