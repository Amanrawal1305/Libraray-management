package com.aman.digitalLibrary.controller;

import com.aman.digitalLibrary.modal.Book;
import com.aman.digitalLibrary.request.CreateBookRequest;
import com.aman.digitalLibrary.response.BookResponse;
import com.aman.digitalLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    BookResponse bookResponse = new BookResponse();
    @PostMapping(value = "/create/book",produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> createBook(@RequestBody CreateBookRequest createBookRequest) {
        if (createBookRequest == null) {
            bookResponse.setErrCode("failed");
            bookResponse.setMessage("Request is Empty");
            return new ResponseEntity<>(bookResponse, HttpStatus.OK);

        }
        Book book = bookService.createStudentInDatabase(createBookRequest);
        if (book == null) {
            bookResponse.setErrCode("failed");
            bookResponse.setMessage("data not inserted");
            return new ResponseEntity<>(bookResponse, HttpStatus.OK);

        }
        bookResponse.setErrCode("Success");
        bookResponse.setMessage("book is inserted");
        bookResponse.setBookId(book.getBookId() + "");
        bookResponse.setBookName(book.getBookName());
        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);


    }
}
