package com.example.BookManager.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteBorrowRequest {
    public long UserID;
    public long BookID;
}
