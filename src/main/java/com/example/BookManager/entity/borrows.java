package com.example.BookManager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrows")
@Data
public class borrows {
    @EmbeddedId
    private borrowID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "UserID", nullable = false)
    @JsonBackReference
    private users user;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    @JoinColumn(name = "BookID", nullable = false)
    @JsonBackReference
    private books book;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime borrowedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private LocalDateTime returnedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime due;
}
