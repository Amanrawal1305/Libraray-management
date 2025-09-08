package com.aman.digitalLibrary.response;

import com.aman.digitalLibrary.modal.Book;
import com.aman.digitalLibrary.modal.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse extends Response{
    private String transactionType;
    private String bookName ;
}
