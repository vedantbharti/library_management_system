package com.library.digital.bookdetails.repository;

import com.library.digital.bookdetails.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {

    public BookEntity findByBookId(Long bookId);

    public BookEntity findByIsbn(String isbn);

    public List<BookEntity> findAllByBookName(String bookName);

    @Query("SELECT * FROM BookEntity b JOIN b.bookAuthor a WHERE a.authorName = ?1")
    public List<BookEntity> findAllByBookAuthor(String authorName);


    public List<BookEntity> findAllByGenre(String genre);

    public List<BookEntity> findAllByLanguage(String language);
}
