package com.library.digital.bookdetails.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors", schema = "library_management_system")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "author_id")
    private Long authorId;

    @Column(name = "author_name")
    private String authorName;


    @ManyToMany
    @JoinTable(name = "author_books",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"))
    private List<BookEntity> books;

    @Column(name = "author_nationality")
    private String authorNationality;

    @Column(name = "about_author")
    private String aboutAuthor;
}
