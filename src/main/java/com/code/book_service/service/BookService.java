package com.code.book_service.service;

import com.code.book_service.model.Book;
import com.code.book_service.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book addBook(Book book){
        return bookRepo.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public List<Book> getBookByAuthorId(String authorId){
        return bookRepo.findByBookAuthorId(authorId);
    }

    public Optional<Book> getBookById(String bookId){
        return bookRepo.findByBookId(bookId);
    }

    public Book deleteBookById(String bookId){
        Optional<Book> book = bookRepo.findById(bookId);
        if(book.isPresent()){
            bookRepo.deleteById(bookId);
            return book.get();
        }
        return null;
    }
}
