package com.example.BookManager.controller;

import com.example.BookManager.dto.requests.CreateBorrowRequest;
import com.example.BookManager.dto.requests.DeleteBorrowRequest;
import com.example.BookManager.entity.borrows;
import com.example.BookManager.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/borrows")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping()
    borrows createBorrow(@RequestBody CreateBorrowRequest request)
    {
        return borrowService.createBorrow(request);
    }
    @GetMapping()
    List<borrows> readBorrows()
    {
        return borrowService.readBorrows();
    }
    @DeleteMapping()
    String deleteBorrow(@RequestBody DeleteBorrowRequest request)
    {
        borrowService.deleteBorrow(request);
        return "Delete borrows successfully";
    }
}
