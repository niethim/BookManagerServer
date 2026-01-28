package com.example.BookManager.service;

import com.example.BookManager.dto.requests.CreateBorrowRequest;
import com.example.BookManager.dto.requests.DeleteBorrowRequest;
import com.example.BookManager.entity.books;
import com.example.BookManager.entity.borrows;
import com.example.BookManager.entity.users;
import com.example.BookManager.entity.borrowID;
import com.example.BookManager.repository.BorrowRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Transactional
    public borrows createBorrow(CreateBorrowRequest request)
    {
        borrows borrow = new borrows();
        Long UserID = request.getUserID();
        Long BookID = request.getBookID();
        borrowID newBorrowID = new borrowID();
        newBorrowID.setBookId(BookID);
        newBorrowID.setUserId(UserID);
        borrow.setId(newBorrowID);
        users user = userService.findUserByUserID(UserID);
        books book = bookService.findBookByBookID(BookID);
        updateBook(book, -1);
        borrow.setUser(user);
        borrow.setBook(book);
        borrow.setBorrowedAt(request.getBorrowedAt());
        borrow.setReturnedAt(null);
        borrow.setDue(request.getBorrowedAt().plusDays(60));
        return borrowRepository.save(borrow);
    }
    private void updateBook(books book, int status)
    {
        if(status == -1)
            book.setQuantity(book.getQuantity() - 1);
        else
            book.setQuantity(book.getQuantity() + 1);
        bookService.saveBook(book);
    }
    public List<borrows> readBorrows()
    {
        return borrowRepository.findAll();
    }
    public void deleteBorrow(DeleteBorrowRequest request)
    {
        borrowID newBorrowID = new borrowID();
        newBorrowID.setUserId(request.getUserID());
        newBorrowID.setBookId(request.getBookID());
        borrows foundBorrow = borrowRepository.findById(newBorrowID)
                .orElseThrow(() -> new RuntimeException("borrow pair not found"));
        borrowRepository.delete(foundBorrow);
        books book = bookService.findBookByBookID(request.getBookID());
        updateBook(book, 1);
    }
    public long getNumberOfBorrow()
    {
        return borrowRepository.getNumberOfBorrow();
    }
}
