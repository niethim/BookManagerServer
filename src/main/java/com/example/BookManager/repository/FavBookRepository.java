package com.example.BookManager.repository;

import com.example.BookManager.entity.favID;
import com.example.BookManager.entity.favouritebooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavBookRepository extends JpaRepository<favouritebooks, favID> {
    @Query("select f from favouritebooks f where f.user.userId = :userId")
    public List<favouritebooks> findAllByUserID(@Param("userId") Long userId);
}
