package com.example.BookManager.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userId;

    @Column(name = "Role", nullable = false)
    private int role;

    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "PasswordHash", nullable = false)
    private String passwordHash;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<borrows> borrows;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<favouritebooks> favouriteBooks;
}
