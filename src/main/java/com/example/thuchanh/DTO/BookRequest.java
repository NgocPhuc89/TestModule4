package com.example.thuchanh.DTO;

import com.example.thuchanh.model.Author;
import com.example.thuchanh.model.Category;
import com.example.thuchanh.model.enums.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookRequest {
    private String title;
    private String description;
    private LocalDate publishDate;
    private String price;
    private Category category;
    private Author author;
    private Type type;
}
