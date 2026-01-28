package com.example.BookManager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "books")
@Data
public class books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID")
    private Long bookId;
    @Column(nullable = false)
    private String title;
    private int publishedYear;
    private String publisher;
    private String authorName;
    private long quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryID", nullable = false)
    @JsonBackReference
    private categories category;
    @OneToMany(mappedBy = "book")
    @JsonManagedReference
    private List<borrows> borrows;
    @OneToMany(mappedBy = "book")
    @JsonManagedReference
    private List<favouritebooks> favouritebooksByUser;
}
