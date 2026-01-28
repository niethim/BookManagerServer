package com.example.BookManager.service;

import com.example.BookManager.dto.requests.CreateBookRequest;
import com.example.BookManager.dto.requests.UpdateBookRequest;
import com.example.BookManager.entity.books;
import com.example.BookManager.entity.categories;
import com.example.BookManager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryService categoryService;

    public books createBook(CreateBookRequest request)
    {
        categories category =
                categoryService.findByCategoryID(request.getCategoryID());
        books newBook = new books();
        newBook.setTitle(request.getTitle());
        newBook.setAuthorName(request.getAuthorName());
        newBook.setPublisher(request.getPublisher());
        newBook.setQuantity(request.getQuantity());
        newBook.setPublishedYear(request.getPublishedYear());

        newBook.setCategory(category);

        return bookRepository.save(newBook);
    }
    public List<books> readBooks()
    {
        return bookRepository.findAll();
    }
    public books findBookByBookID(Long BookID)
    {
        return bookRepository.findById(BookID)
                .orElseThrow(() -> new RuntimeException("Book not founded"));
    }
    public void deleteBook(long BookID)
    {
        books foundedBook = findBookByBookID(BookID);
        bookRepository.delete(foundedBook);
    }
    public books updateBook(UpdateBookRequest request, long id)
    {
        categories category =
                categoryService.findByCategoryID(request.getCategoryID());
        books foundBook = findBookByBookID(id);
        foundBook.setTitle(request.getTitle());
        foundBook.setAuthorName(request.getAuthorName());
        foundBook.setPublisher(request.getPublisher());
        foundBook.setQuantity(request.getQuantity());
        foundBook.setPublishedYear(request.getPublishedYear());
        foundBook.setCategory(category);

        return bookRepository.save(foundBook);
    }
    public void saveBook(books book)
    {
        bookRepository.save(book);
    }
    public long getNumberOfAddedBook()
    {
        return bookRepository.getNumberOfAddedBook();
    }
}
