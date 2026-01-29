package com.example.BookManager.controller;

import com.example.BookManager.dto.requests.CreateBookRequest;
import com.example.BookManager.dto.requests.UpdateBookRequest;
import com.example.BookManager.dto.responses.ApiResponse;
import com.example.BookManager.entity.books;
import com.example.BookManager.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController  {
    @Autowired
    private BookService bookService;
    @PostMapping()
    ApiResponse<books> createBook(@RequestBody CreateBookRequest request)
    {
        ApiResponse<books> apiResponse = new ApiResponse<>();
        apiResponse.setResult(bookService.createBook(request));
        return apiResponse;
    }
    @GetMapping()
    List<books> readBooks()
    {
        return bookService.readBooks();
    }
    @DeleteMapping(path = "/{BookID}")
    String deleteBook(@PathVariable long BookID )
    {
        bookService.deleteBook(BookID);
        return "Book has been deleted";
    }
    @GetMapping(path = "/{BookID}")
    books readBook(@PathVariable long BookID)
    {
        return bookService.findBookByBookID(BookID);
    }
    @PutMapping(path = "/{BookID}")
    books updateBook(@RequestBody UpdateBookRequest request, @PathVariable long BookID)
    {
        return bookService.updateBook(request, BookID);
    }
}
