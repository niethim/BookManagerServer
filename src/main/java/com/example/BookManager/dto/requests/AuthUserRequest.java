package com.example.BookManager.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUserRequest {
    String Username;
    String Password;
}
