package com.example.BookManager.dto.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CreateFavbookRequest {
    private Long bookId;
}
