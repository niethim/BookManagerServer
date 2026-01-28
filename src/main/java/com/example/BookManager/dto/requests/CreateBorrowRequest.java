package com.example.BookManager.dto.requests;

import com.example.BookManager.entity.borrowID;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class CreateBorrowRequest {
    private Long userID;
    private Long bookID;
    private LocalDateTime borrowedAt;
}
