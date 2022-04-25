package com.example.library.model.Dataholder;


import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Country;
import com.example.library.model.Enumerations.Category;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.CountryRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Book> books=new ArrayList<>();
    public static List<Author> authors=new ArrayList<>();
    public static List<Country> countries=new ArrayList<>();

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;

    public DataHolder(AuthorRepository authorRepository, BookRepository bookRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init(){

        Country country1=new Country("France","Europe");
        Country country2=new Country("England","Europe");
        Country country3=new Country("Bosnia","Europe");

        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        this.countryRepository.save(country3);

        Author author1=new Author("Albert","Camus",country1);
        Author author2=new Author("William","Shakespeare",country2);
        Author author3=new Author("Ivo","Andric",country3);

        this.authorRepository.save(author1);
        this.authorRepository.save(author2);
        this.authorRepository.save(author3);

        Book book1=new Book("The Stranger", Category.NOVEL,author1,100);
        Book book2=new Book("Hamlet",Category.CLASSICS,author2,10);
        Book book3=new Book("The Bridge on the Drina",Category.HISTORY,author3,1);

        this.bookRepository.save(book1);
        this.bookRepository.save(book2);
        this.bookRepository.save(book3);


    }
}
