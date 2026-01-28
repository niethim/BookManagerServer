package com.example.BookManager.repository;

import com.example.BookManager.entity.categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<categories, Long> {
    @Query(value = """
          SELECT c.category_name
          FROM categories c
          JOIN books b ON b.categoryid = c.categoryid
          JOIN borrows br ON br.bookid = b.bookid
          GROUP BY c.categoryid
          ORDER BY COUNT(*) DESC
          LIMIT 1
        """, nativeQuery = true)
    public String findMostPopularCategory();
}

