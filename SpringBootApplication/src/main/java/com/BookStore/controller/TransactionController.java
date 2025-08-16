package com.BookStore.controller;

import com.BookStore.dto.TransactionRequestDTO;
import com.BookStore.dto.TransactionResponseDTO;
import com.BookStore.entity.Transaction;
import com.BookStore.service.impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private TransactionService TransactionService;

    @Autowired
    public TransactionController(TransactionService TransactionService){
        this.TransactionService=TransactionService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Transaction>> ListTransactionById(@PathVariable Integer id){
        TransactionResponseDTO Transactions=  this.TransactionService.getAllTransactionById(id);
        return new ResponseEntity(Transactions, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Transaction>> ListAllTransaction(){
        List<TransactionResponseDTO> Transactions=  this.TransactionService.getAllTransaction();
        return new ResponseEntity(Transactions, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Transaction> saveTransaction(@RequestBody TransactionRequestDTO u){
        Transaction Transaction=  this.TransactionService.saveTransaction(u);
        return new ResponseEntity(Transaction, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Boolean DeleteTransactionById(@PathVariable Integer id){
        Boolean isDeleted=  this.TransactionService.deleteTransactionById(id);
        return isDeleted;
    }
}
