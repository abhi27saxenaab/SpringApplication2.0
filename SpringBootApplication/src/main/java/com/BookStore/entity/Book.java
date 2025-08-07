package com.BookStore.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="books")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String title;
    private String isbn;
    private int authorId;
}
