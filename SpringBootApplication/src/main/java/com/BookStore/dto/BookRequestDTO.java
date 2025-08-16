package com.BookStore.dto;

import com.BookStore.entity.Book;
import lombok.Data;

import java.util.Date;

@Data
public class BookRequestDTO {
    private String title;
    private String isbn;
    private int publisher_id;
    private int genre_id;
    private int authorId;
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
