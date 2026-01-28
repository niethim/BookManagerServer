package com.example.BookManager.repository;

import com.example.BookManager.entity.books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<books, Long> {
    // support basic CRUD
    @Query(
        """
        select count(distinct bookId)
        from books    
        """
    )
    long getNumberOfAddedBook();
}
