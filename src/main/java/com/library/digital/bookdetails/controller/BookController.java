package com.library.digital.bookdetails.controller;

import com.library.digital.bookdetails.entity.BookEntity;
import com.library.digital.bookdetails.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public List<BookEntity> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/book", params = "id")
    public BookEntity getBooksById(@RequestParam Long id){
        return bookService.getBookDetailsById(id);
    }

    @GetMapping(value = "/book", params = "isbn")
    public  BookEntity getBooksBYIsbn(@RequestParam String isbn){
        return bookService.getBookDetailsByIsbn(isbn);
    }

    @GetMapping(value = "/books", params = "name")
    public List<BookEntity> getBooksByName(@RequestParam String name){
        return bookService.getBooksByName(name);
    }

    @GetMapping(value = "/books", params = "author")
    public List<BookEntity> getBooksByAuthor(@RequestParam String author){
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping(value = "/books", params = "genre")
    public List<BookEntity> getBooksByGenre(@RequestParam String genre){
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping(value = "/books", params = "language")
    public List<BookEntity> getBooksByLanguage(@RequestParam String language){
        return bookService.getBooksByLanguage(language);
    }

    @PostMapping(value = "/add_book")
    public String addBook(@RequestBody BookEntity book){
        if(bookService.saveBookDetails(book)){
            return "Book added successfully!";
        } else {
            return "Couldn't add book!";
        }
    }

    @PutMapping(value = "/update_book")
    public String updateBookDetails(@Validated @RequestBody BookEntity book){
        if(bookService.saveBookDetails(book)){
            return "Description successfully updated!";
        } else {
            return "Couldn't update description!";
        }
    }

    @DeleteMapping(value = "/delete_book", params = "id")
    public String deleteBook(@RequestParam Long id){
        if(bookService.deleteBookRecord(id)){
            return "Record deleted!";
        } else {
            return "Couldn't delete the record!";
        }
    }
}
