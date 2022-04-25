package com.example.library.service;

import com.example.library.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long id);
}
