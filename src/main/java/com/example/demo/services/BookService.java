package com.example.demo.services;

import com.example.demo.dtos.CreateBookRequest;
import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book createNewBook(CreateBookRequest createBookRequest) throws ParseException{
        var newBook = new Book();
        newBook.setTitle(createBookRequest.getTitle());
        newBook.setDescription(createBookRequest.getDescription());
        newBook.setPrice(createBookRequest.getPrice());
        bookRepository.save(newBook);
        return newBook;
    }
}
