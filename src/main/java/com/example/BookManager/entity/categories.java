package com.example.BookManager.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private long CategoryID;
    @Column(name = "CategoryName", nullable = false)
    private String CategoryName;
    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<books> books;
}
