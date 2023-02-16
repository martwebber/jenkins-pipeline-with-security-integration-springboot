package com.example.demo.controllers;

import com.example.demo.dtos.CreateBookRequest;
import com.example.demo.entities.Book;
import com.example.demo.services.BookService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        var books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewBook(@RequestBody CreateBookRequest createBookRequest) throws ParseException{
        var newBook = bookService.createNewBook(createBookRequest);
        return ResponseEntity.status(201).body(newBook);
    }
}
