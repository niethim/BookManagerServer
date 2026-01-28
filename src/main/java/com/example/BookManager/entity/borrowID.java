package com.example.BookManager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class borrowID implements Serializable {
    private long userId;
    private long bookId;
}
