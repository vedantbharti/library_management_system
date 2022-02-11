package com.library.digital.bookdetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Book {
    private long bookId;
    private String bookName;
    private String isbn;
    private Author bookAuthor;
    private int totalNumberOfCopies;
    private int numberOfCopiesAvailable;
    private String genre;
    private String language;
    private String description;
    private long credits;
}
