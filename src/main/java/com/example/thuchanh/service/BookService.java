package com.example.thuchanh.service;

import com.example.thuchanh.DTO.BookRequest;
import com.example.thuchanh.model.Author;
import com.example.thuchanh.model.Book;
import com.example.thuchanh.model.Category;
import com.example.thuchanh.repository.AuthorRepository;
import com.example.thuchanh.repository.BookRepository;
import com.example.thuchanh.repository.CategoryRepository;
import com.example.thuchanh.utils.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book create (BookRequest bookRequest){
        Book book = AppUtils.mapper.map(bookRequest , Book.class);
        bookRepository.save(book);
        return book;
    }

    public Book findId(Long id){
        return bookRepository.findById(id).get();
    }

    public void update (BookRequest bookRequest, Long id){
        Book book = AppUtils.mapper.map(bookRequest , Book.class);
        book.setId(id);

        bookRepository.save(book);
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }


}
