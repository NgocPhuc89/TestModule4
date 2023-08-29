package com.example.thuchanh.repository;

import com.example.thuchanh.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book , Long> {
}
