package com.aman.digitalLibrary.service;

import com.aman.digitalLibrary.exception.BookAlreadyPresent;
import com.aman.digitalLibrary.modal.Author;
import com.aman.digitalLibrary.modal.Book;
import com.aman.digitalLibrary.repository.BookDao;
import com.aman.digitalLibrary.repository.AuthorDao;
import com.aman.digitalLibrary.request.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;
    public Book createStudentInDatabase(CreateBookRequest createBookRequest){
        String bookId = String.valueOf(createBookRequest.getBookId());
        String bookName=createBookRequest.getBookName();
        String bookType =createBookRequest.getBookType().toString();
        String authorEmail=createBookRequest.getAuthorEmail();
        Book bookResult =null;

        try{
            int status =bookDao.findBookById(bookId);
            if(status>0){
                throw  new BookAlreadyPresent("Book is already in database");
            }
            int result = bookDao.createBookInDatabase(bookId, bookName, bookType, authorEmail);
            if (result <= 0) {
                return null;
            }

            boolean isAuthorExist = false;

            AuthorDao authorDao = new AuthorDao();
            try {
                Author authorExist = authorDao.findAuthorById(authorEmail);
                isAuthorExist = true;
            }
            catch (Exception e) {
                isAuthorExist = false;
            }

            if (isAuthorExist == true) {
                return bookResult;
            }

            authorDao.createAuthor(CreateBookRequest.toAuthor(createBookRequest));




        } catch (BookAlreadyPresent e) {
            throw new RuntimeException(e);

        }
        return bookResult;


    }
}
