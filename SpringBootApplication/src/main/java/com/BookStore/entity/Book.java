package com.BookStore.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name="books")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    public enum status {
        AVAILABLE, CHECKEDOUT,LOST,DAMAGED
    }
    public enum bookcondition {
        NEW, GOOD, FAIR, POOR
    }
    @Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name="custom-id", strategy = "com.BookStore.util.CustomIdGenerator")
    private int bookId;
    @Size(max = 2, message = "Field must not exceed 50 characters")
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author authorId;
    private int publisher_id;

    @ManyToOne
    @JoinColumn(name="genre_id")
    private Genre genreId;
//    private int genre_id;
    private String isbn;
    private Date publication_date;
    private String edition;
    private String language;
    private int page_count;
    private String description;
    private String cover_image;
    private int quantity_in_stock;
    private String status;
    private String bookcondition;
    private Date acquisition_date;
    private double acquisition_price;
    private String barcode;

}
