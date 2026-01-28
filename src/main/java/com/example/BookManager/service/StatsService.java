package com.example.BookManager.service;

import com.example.BookManager.dto.responses.StatsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    private BorrowService borrowService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    public StatsResponse readStats()
    {
        StatsResponse response = new StatsResponse();
        response.setMostPopularCategory(categoryService.getMostPopularCategory());
        response.setNumberOfBorrowBook(borrowService.getNumberOfBorrow());
        response.setNumberOfRegisteredUser(userService.getNumberOfRegisteredUser());
        response.setNumberOfAddedBook(bookService.getNumberOfAddedBook());
        return response;
    }
}
