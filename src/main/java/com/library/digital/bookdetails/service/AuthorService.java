package com.library.digital.bookdetails.service;

import com.library.digital.bookdetails.entity.AuthorEntity;
import com.library.digital.bookdetails.entity.BookEntity;
import com.library.digital.bookdetails.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorEntity getAuthorsById(Long authorId){
        return authorRepository.findByAuthorId(authorId);
    }

    public List<AuthorEntity> getAuthorsByName(String authorName){
        return authorRepository.findAllByAuthorName(authorName);
    }

    public List<AuthorEntity> getAuthorsByNationality(String authorNationality){
        return authorRepository.findAllByAuthorNationality(authorNationality);
    }

    public List<AuthorEntity> getAuthorsForBook(String books){
        return authorRepository.findAllByBooks(books);
    }

    public boolean saveAuthorDetails(AuthorEntity authorEntity){
        AuthorEntity result;
        try{
            result = authorRepository.save(authorEntity);
            if(result!=null) return true;
        } catch (Exception e){
            log.info("Unable to save the record: {}", e.getMessage());
        }

        return false;
    }

    public boolean updateBooksByAuthor(Long authorId, BookEntity bookEntity){
        try{
            AuthorEntity author = authorRepository.findByAuthorId(authorId);
            List<BookEntity> bookEntityList = author.getBooks();
            bookEntityList.add(bookEntity);
            author.setBooks(bookEntityList);
        } catch(Exception e){
            log.info("Unable to update the records: {}", e.getMessage());
            return false;
        }

        return true;
    }

    public boolean deleteRecordsForAuthor(Long authorId){
        try{
            authorRepository.deleteById(authorId);
        } catch(Exception e){
            log.info("Either record doesn't exist or couldn't delete the record: {}", e.getMessage());
            return false;
        }

        return true;
    }
}
