package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Enumerations.Category;
import com.example.library.model.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> edit(Long id, BookDto bookDto);

    Optional<Book> markAsTaken(Long id);
}
