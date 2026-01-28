package com.example.BookManager.repository;

import com.example.BookManager.entity.books;
import com.example.BookManager.entity.borrowID;
import com.example.BookManager.entity.borrows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<borrows, borrowID> {
    @Query(
    """
        select count(distinct b.id)
        from borrows b
    """
    )
    public long getNumberOfBorrow();
}
