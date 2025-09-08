package com.aman.digitalLibrary.request;

import com.aman.digitalLibrary.modal.Author;
import com.aman.digitalLibrary.modal.BookType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBookRequest {
    int bookId;
    String bookName;
    BookType bookType;
    String authorName;
    String authorEmail;
    String authorNumber;

    public static Author toAuthor(CreateBookRequest request){
        Author author =Author.builder().email(request.getAuthorEmail()).name(request.getAuthorName()).phoneNo(request.getAuthorNumber()).build();
        return author;
    }





}
