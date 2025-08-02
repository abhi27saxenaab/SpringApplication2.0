package com.BookStore.repository;
import com.BookStore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
