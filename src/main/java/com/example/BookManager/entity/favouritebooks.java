package com.example.BookManager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "favouritebooks")
@Data
public class favouritebooks {
    @EmbeddedId
    private favID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "UserID", nullable = false)
    @JsonIgnore
    private users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    @JoinColumn(name = "BookID", nullable = false)
    @JsonIgnore
    private books book;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
}
