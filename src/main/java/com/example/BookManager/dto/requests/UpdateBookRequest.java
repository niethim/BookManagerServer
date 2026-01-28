package com.example.BookManager.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookRequest {
    private String title;
    private int publishedYear;
    private String publisher;
    private String authorName;
    private long quantity;
    private long CategoryID;
}
