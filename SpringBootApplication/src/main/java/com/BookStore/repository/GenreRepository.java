package com.BookStore.repository;


import com.BookStore.dto.GenreBookResponseDTO;
import com.BookStore.entity.Book;
import com.BookStore.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    //@Query(value = "select title, genre_id,isbn from books where genre_id =:id",nativeQuery = true)
    @Query(value = "select b.title, b.genre_id,b.isbn,g.name as genre_name from books as b left join genres g on \n" +
            "b.genre_id = g.genre_id   where b.genre_id=:id",nativeQuery = true)
    List<GenreBookResponseDTO> ListAllBooksGenreById(@Param("id") Integer id);
}
