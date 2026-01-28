package com.example.BookManager.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatsResponse {
    public String MostPopularCategory;
    public long NumberOfBorrowBook;
    public long NumberOfRegisteredUser;
    public long NumberOfAddedBook;
}
