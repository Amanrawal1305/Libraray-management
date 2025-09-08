package com.aman.digitalLibrary.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    int id;
    Student student;
    long paidAmount;
    Book book;
    Timestamp CreatedOn;
    Timestamp updatedOn;
    TransactionType type;


    public String getBook() {
        return null;
    }
//    public Book setBook(Book book){
//
//    }


    public void setCreatedOn(java.sql.Timestamp issuedTime) {
    }
}
