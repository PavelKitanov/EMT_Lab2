package com.example.library.service;

import com.example.library.model.Author;

import java.util.List;
import java.util.Optional;


public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);
}
