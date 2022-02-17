package com.library.digital.bookdetails.repository;

import com.library.digital.bookdetails.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {

    BookEntity findByBookId(Long bookId);

    BookEntity findByIsbn(String isbn);

    List<BookEntity> findAllByBookName(String bookName);

    //@Query("SELECT * FROM BookEntity b WHERE ?1 IN (SELECT a.authorName FROM b.bookAuthor a WHERE a.authorName = ?1)")
    List<BookEntity> findByBookAuthorAuthorName(String authorName);


    List<BookEntity> findAllByGenre(String genre);

    List<BookEntity> findAllByLanguage(String language);
}
