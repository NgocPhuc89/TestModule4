package com.example.thuchanh.service;

import com.example.thuchanh.model.Author;
import com.example.thuchanh.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> findAll(){
        return  authorRepository.findAll();
    }
}
