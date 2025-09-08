package com.aman.digitalLibrary.controller;

import com.aman.digitalLibrary.modal.Transaction;
import com.aman.digitalLibrary.request.BookTransactionRequest;
import com.aman.digitalLibrary.response.TransactionResponse;
import com.aman.digitalLibrary.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/book/initiate")
    public ResponseEntity<TransactionResponse> initiateTransaction(@RequestBody BookTransactionRequest bookTransactionRequest){
        TransactionResponse transactionResponse = new TransactionResponse();
        if(bookTransactionRequest==null){
            transactionResponse.setErrCode("Failed");
            transactionResponse.setMessage("request is empty");
            return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
        }
        Transaction transaction=transactionService.createTransaction(bookTransactionRequest);
        if(transaction==null){
            transactionResponse.setErrCode("Failed");
            transactionResponse.setMessage("not completed,please retry");
            return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
        }
        transactionResponse.setTransactionType(bookTransactionRequest.getRequestType());
        transactionResponse.setBookName(transaction.getBook());
        transactionResponse.setMessage("Book"+ bookTransactionRequest.getRequestType());
        transactionResponse.setErrCode("Success");
        return new ResponseEntity<>(transactionResponse,HttpStatus.CREATED);
    }
}
