package com.aman.digitalLibrary.service;

import com.aman.digitalLibrary.modal.Book;
import com.aman.digitalLibrary.modal.Transaction;
import com.aman.digitalLibrary.repository.BookDao;
import com.aman.digitalLibrary.repository.TransactionDao;
import com.aman.digitalLibrary.request.BookTransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    BookDao bookDao;
    public Transaction createTransaction(BookTransactionRequest request){
        int row=transactionDao.issueBookToStudent(request);
        if(row<0){
            return  null;
        }
        Book book =bookDao.findBookById(request.getBookId());
        Transaction transaction=new Transaction();
        transaction.setBook(book);
        return transaction;

    }
}
