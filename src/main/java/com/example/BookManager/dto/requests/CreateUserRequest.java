package com.example.BookManager.dto.requests;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private int role;
    private String username;
    private String passwordHash;
}
