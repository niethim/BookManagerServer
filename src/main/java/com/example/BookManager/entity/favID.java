package com.example.BookManager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class favID implements Serializable {
    @Column(name = "UserID")
    private Long userId;
    @Column(name = "BookID")
    private Long bookId;
}
