package com.example.BookManager.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private int code = 1000;
    private String message;
    private T result;
}
