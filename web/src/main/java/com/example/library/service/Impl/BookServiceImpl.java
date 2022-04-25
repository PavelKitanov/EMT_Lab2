package com.example.library.service.Impl;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Exceptions.AuthorNotFoundException;
import com.example.library.model.Exceptions.BookNotFoundException;
import com.example.library.model.Exceptions.CopiesNotFoundException;
import com.example.library.model.dto.BookDto;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author=this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(()-> new AuthorNotFoundException(bookDto.getAuthor()));

        this.bookRepository.deleteByName(bookDto.getName());
        Book book=new Book(bookDto.getName(),bookDto.getCategory(),author,bookDto.getAvailableCopies());
        this.bookRepository.save(book);

        return Optional.of(book);
    }


    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book=this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        Author author=this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(()-> new AuthorNotFoundException(bookDto.getAuthor()));
        book.setAuthor(author);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book=this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        if(book.getAvailableCopies()<=0){
            throw new CopiesNotFoundException(id);
        }

        book.setAvailableCopies(book.getAvailableCopies()-1);

        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
