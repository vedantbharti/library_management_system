package com.library.digital.bookdetails.service;

import com.library.digital.bookdetails.entity.BookEntity;
import com.library.digital.bookdetails.model.Book;
import com.library.digital.bookdetails.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Service
public class BookService {

    @Autowired
    private Book book;

    private BookEntity bookEntity;

    @Autowired
    private BookRepository bookRepository;

    private List<BookEntity> bookEntityList;

    public boolean saveBookDetails(BookEntity book){
        boolean saveStatus = false;
        try{
            bookRepository.save(book);
            saveStatus = true;
        } catch(Exception e){
            log.info("Error occurred while saving the book details: {}", e.getMessage());
        }
        return saveStatus;
    }


    public List<BookEntity> getAllBooks(){
        return bookRepository.findAll();
    }

    public BookEntity getBookDetailsById(Long id){
        try{
            bookEntity = bookRepository.findByBookId(id);
        } catch (Exception e){
            log.info("Error occurred while fetching the book details by Id: {}", e.getMessage());
        }

        return bookEntity;
    }

    public BookEntity getBookDetailsByIsbn(String isbn){
        try{
            bookEntity = bookRepository.findByIsbn(isbn);
        } catch (Exception e){
            log.info("Error occurred while fetching the book details by ISBN: {}", e.getMessage());
        }

        return bookEntity;
    }


    public List<BookEntity> getBooksByName(String bookName){

        try{
            bookEntityList = bookRepository.findAllByBookName(bookName);
        } catch(Exception e){
            log.info("Error occurred while fetching the books by name: {}", e.getMessage());
        }

        return bookEntityList;
    }

    public List<BookEntity> getBooksByAuthor(String authorName){
        try{
            bookEntityList = bookRepository.findAllByBookAuthor(authorName);
        } catch(Exception e){
            log.info("Error occurred while fetching the books by author: {}", e.getMessage());
        }

        return bookEntityList;
    }


    public List<BookEntity> getBooksByGenre(String genre){
        try{
            bookEntityList = bookRepository.findAllByGenre(genre);
        } catch(Exception e){
            log.info("Error occurred while fetching the books by genre: {}", e.getMessage());
        }

        return bookEntityList;
    }


    public List<BookEntity> getBooksByLanguage(String language){
        try{
            bookEntityList = bookRepository.findAllByLanguage(language);
        } catch(Exception e){
            log.info("Error occurred while fetching the books by language: {}", e.getMessage());
        }

        return bookEntityList;
    }

    public boolean deleteBookRecord(Long id){
        boolean deleteStatus = false;
        try{
            bookRepository.deleteById(id);
            deleteStatus = true;
        } catch(Exception e){
            log.info("Error occurred while deleting the book details: {}", e.getMessage());
        }
        return deleteStatus;
    }
}
