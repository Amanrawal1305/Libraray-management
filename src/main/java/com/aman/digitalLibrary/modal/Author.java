package com.aman.digitalLibrary.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private int authorId;
    private String name;
    private String email;
    private String phoneNo;
    private List<Book> bookList;


}
