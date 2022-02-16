package com.library.digital.bookdetails.repository;

import com.library.digital.bookdetails.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {

    AuthorEntity findByAuthorId(Long authorId);

    List<AuthorEntity> findAllByAuthorName(String authorName);

    List<AuthorEntity> findAllByAuthorNationality(String authorNationality);


    @Query("SELECT * FROM AuthorEntity a WHERE (SELECT b.bookName FROM a.books b WHERE b.bookName = ?1)")
    List<AuthorEntity> findAllByBooks(String booksName);
}
