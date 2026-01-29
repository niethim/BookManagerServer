package com.example.BookManager.controller;

import com.example.BookManager.dto.requests.CreateFavbookRequest;
import com.example.BookManager.dto.requests.CreateUserRequest;
import com.example.BookManager.entity.favouritebooks;
import com.example.BookManager.entity.users;
import com.example.BookManager.service.favbook.FavBookService;
import com.example.BookManager.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FavBookService favBookService;
    @PostMapping("/users")
    users CreateUser (@RequestBody CreateUserRequest request)
    {
        return userService.createUser(request);
    }
    @GetMapping("/users")
    List<users> ReadUsers()
    {
        return userService.readUsers();
    }
    @GetMapping("/users/{UserID}")
    users ReadUser(@PathVariable Long UserID)
    {
        return userService.findUserByUserID(UserID);
    }
    @GetMapping("/users/{UserID}/favbooks")
    List<favouritebooks> ReadFavBooks(@PathVariable Long UserID)
    {
        return favBookService.readFavBooks(UserID);
    }
    @PostMapping("/users/{UserID}/favbooks")
    favouritebooks createFavBook(@PathVariable Long UserID, @RequestBody CreateFavbookRequest request) {
        return favBookService.createFavBook(request, UserID);
    }
    @DeleteMapping("/users/{UserID}/favbooks/{BookID}")
    String deleteFavBook(@PathVariable Long UserID, @PathVariable Long BookID)
    {
        favBookService.deleteFavBooks(BookID, UserID);
        return "Delete favourite book successfully";
    }
}
