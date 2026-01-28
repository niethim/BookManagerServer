package com.example.BookManager.repository;

import com.example.BookManager.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<users, Long> {
    Optional<users> findByUsername(String Username);
    @Query(
            """
            select count(distinct u.userId)
            from users u
            """
    )
    public long getNumberOfRegisteredUser();
}
