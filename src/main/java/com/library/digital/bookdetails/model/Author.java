package com.library.digital.bookdetails.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private Long authorId;
    private String authorName;
    private String authorNationality;
    private String aboutAuthor;
}
