package com.code.book_service.controller;

import com.code.book_service.model.Book;
import com.code.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/book")
public class bookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping("/getBookByAuthorId/{authorId}")
    public ResponseEntity<List<Book>> getBookByAuthorId(@PathVariable String authorId){
        List<Book> book = bookService.getBookByAuthorId(authorId);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @GetMapping("/getBookById/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable String bookId){
        Book book = bookService.getBookById(bookId).orElse(null);
        if(book != null){
            return ResponseEntity.status(HttpStatus.OK).body(book);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/deleteBookById/{bookId}")
    public ResponseEntity<Book> deleteBookById(@PathVariable String bookId){
        Book book = bookService.deleteBookById(bookId);
        if(book != null){
            return ResponseEntity.status(HttpStatus.OK).body(book);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
