package com.example.thuchanh.API;

import com.example.thuchanh.DTO.BookRequest;
import com.example.thuchanh.model.Book;
import com.example.thuchanh.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookApi {
    private final BookService bookService;
    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findId(@PathVariable Long id){
        Book book = bookService.findId(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookRequest bookRequest){
        Book book = bookService.create(bookRequest);

        return ResponseEntity.ok(book);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update (@RequestBody BookRequest bookRequest , @PathVariable Long id){
        bookService.update(bookRequest , id);

        return ResponseEntity.ok(bookRequest);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
         bookService.delete(id);

         return ResponseEntity.noContent().build();
    }



}
