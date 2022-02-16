package com.library.digital.bookdetails.controller;


import com.library.digital.bookdetails.entity.AuthorEntity;
import com.library.digital.bookdetails.entity.BookEntity;
import com.library.digital.bookdetails.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/author", params = "id")
    public AuthorEntity getAuthorById(@RequestParam Long id){
        return authorService.getAuthorsById(id);
    }

    @GetMapping(value = "/author", params = "name")
    public List<AuthorEntity> getAuthorsByName(@RequestParam String name){
        return authorService.getAuthorsByName(name);
    }

    @GetMapping(value = "/author", params = "nationality")
    public List<AuthorEntity> getAuthorsByNationality(@RequestParam String nationality){
        return authorService.getAuthorsByNationality(nationality);
    }

    @GetMapping(value = "/author", params = "book")
    public List<AuthorEntity> getAuthorsForBook(@RequestParam String book){
        return authorService.getAuthorsForBook(book);
    }

    @PostMapping(value = "/add_author")
    public String addAuthorDetails(@RequestBody AuthorEntity author){
        if(authorService.saveAuthorDetails(author)){
            return "Author added successfully!";
        } else {
            return "Author couldn't be added!";
        }
    }

    @PutMapping(value = "/update_books_by_author", params = "id")
    public String updateBooksByAuthor(@Validated @RequestParam Long id, @RequestBody BookEntity book){
        if(authorService.updateBooksByAuthor(id,book)){
            return "Book update for the author!";
        } else {
            return "Couldn't update book for the author!";
        }
    }

    @DeleteMapping(value = "/delete_author", params = "id")
    public String deleteAuthorRecord(@RequestParam Long id){
        if(authorService.deleteRecordsForAuthor(id)){
            return "Record deleted!";
        } else {
            return "Couldn't delete the record!";
        }
    }

}
