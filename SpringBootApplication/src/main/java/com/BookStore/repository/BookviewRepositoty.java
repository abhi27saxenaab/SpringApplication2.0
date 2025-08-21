package com.BookStore.repository;

import com.BookStore.dto.BookviewDTO;
import com.BookStore.entity.Bookview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookviewRepositoty extends JpaRepository<Bookview, Integer> {

    @Query(value="select a.*,b.first_name,b.last_name   from bookview as a inner join users as b on a.user_id = b.user_id where a.book_id =:id", nativeQuery = true)
    List<BookviewDTO> findBookView(@Param("id") Integer id);

}
