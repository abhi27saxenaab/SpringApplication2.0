package com.BookStore.dto;

import com.BookStore.entity.Book;
import lombok.Data;

import java.util.Date;

@Data
public class BookResponseDTO {
    private String title;
    private int authorId;
    private int publisher_id;
    private int genre_id;
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
    private String authorName;
    private String genreName;

    private String authorName1;
}
