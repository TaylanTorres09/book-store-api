package com.bookstore.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT obj FROM Book obj WHERE obj.category.id = :idCategory ORDER BY title")
    List<Book> findByCategory(@Param(value = "idCategory") Long idCategory);
    
}
