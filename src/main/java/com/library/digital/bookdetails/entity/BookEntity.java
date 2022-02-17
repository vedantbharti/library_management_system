package com.library.digital.bookdetails.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books", schema = "library_management_system")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_isbn")
    private String isbn;

    @Column(name = "book_author")
    @ManyToMany(mappedBy = "books")
    //@JoinColumn(name = "author_id", referencedColumnName = "bookId")
    private List<AuthorEntity> bookAuthor;

    @Column(name = "book_genre")
    private String genre;

    @Column(name = "book_language")
    private String language;

    @Column(name = "book_description")
    private String description;

//    @Column(name = "credits")
//    private Long credits;
}
