package com.example.BookManager.service;

import com.example.BookManager.dto.requests.CreateFavbookRequest;
import com.example.BookManager.entity.books;
import com.example.BookManager.entity.favID;
import com.example.BookManager.entity.favouritebooks;
import com.example.BookManager.entity.users;
import com.example.BookManager.repository.FavBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FavBookService {
    @Autowired
    private FavBookRepository favBookRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    public favouritebooks createFavBook(CreateFavbookRequest request, Long userID)
    {
        users user = userService.findUserByUserID(userID);
        books book = bookService.findBookByBookID(request.getBookId());
        favouritebooks favbook = new favouritebooks();
        favbook.setCreatedAt(LocalDateTime.now());
        favID newFavID = new favID();
        newFavID.setUserId(userID);
        long newBookID = request.getBookId();
        newFavID.setBookId(newBookID);
        favbook.setId(newFavID);
        favbook.setBook(book);
        favbook.setUser(user);
        favbook.setCreatedAt(LocalDateTime.now());
        return favBookRepository.save(favbook);
    }
    public List<favouritebooks> readFavBooks(Long userID)
    {
        return favBookRepository.findAllByUserID(userID);
    }
    public void deleteFavBooks (Long bookID, Long userID)
    {
        favID favid = new favID();
        favid.setUserId(userID);
        favid.setBookId(bookID);
        favouritebooks favbook = favBookRepository.findById(favid).orElseThrow(() -> new RuntimeException("This pair not found"));
        favBookRepository.delete(favbook);
    }
}
