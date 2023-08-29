package com.example.thuchanh.API;

import com.example.thuchanh.model.Author;
import com.example.thuchanh.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/authors")
public class AuthorApi {

    private final AuthorService authorService;

    @GetMapping
    public List<Author> findAll (){
     return  authorService.findAll();
    }
}
