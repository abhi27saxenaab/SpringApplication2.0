package com.BookStore.service;

import com.BookStore.dto.TransactionRequestDTO;
import com.BookStore.dto.TransactionResponseDTO;
import com.BookStore.entity.Transaction;

import java.util.List;

public interface TransactionService {
    List<TransactionResponseDTO> getAllTransaction();
    TransactionResponseDTO getAllTransactionById(Long id);
    Transaction saveTransaction(TransactionRequestDTO b);
    Boolean deleteTransactionById(Long id);

}
