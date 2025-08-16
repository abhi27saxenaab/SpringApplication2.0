package com.BookStore.service.impl;
import com.BookStore.dto.TransactionRequestDTO;
import com.BookStore.dto.TransactionResponseDTO;
import com.BookStore.entity.Transaction;
import com.BookStore.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private TransactionRepository bookRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public TransactionService(TransactionRepository bookRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
    }

    public List<TransactionResponseDTO> getAllTransaction(){
        List<Transaction> books = bookRepository.findAll();
        List<TransactionResponseDTO> bookdto = books.stream().map(book->
                {
                    TransactionResponseDTO dto = modelMapper.map(book, TransactionResponseDTO.class);
//                    if (book.getAuthorId() != null) {
//                        String authorName = book.getAuthorId().getFirst_name() + " " + book.getAuthorId().getLast_name();
//                        dto.setAuthorName(authorName);
//                    }
                    return dto;
                }
                ).collect(Collectors.toList());
        return bookdto;

    }
    public TransactionResponseDTO getAllTransactionById(Integer id){
        Optional<Transaction> book = bookRepository.findById(id);
        TransactionResponseDTO bookdto = this.modelMapper.map(book, TransactionResponseDTO.class);
        return bookdto;
    }
    public Transaction saveTransaction(TransactionRequestDTO t){
        Transaction t1 = new Transaction();
        t1.setUser_id(t.getUser_id());
        t1.setBook_id(t.getBook_id());
        t1.setCheckout_date(t.getCheckout_date());
        t1.setDue_date(t.getDue_date());
        t1.setReturn_date(t.getReturn_date());
        t1.setStatus(t.getStatus());
        t1.setNotes(t.getNotes());
        return bookRepository.save(t1);
    }
    public Boolean deleteTransactionById(Integer id){
       Optional<Transaction> book = bookRepository.findById(id);
        if(book.isEmpty()){
            return false;
        }else {
            bookRepository.deleteById(id);
            return true;
        }
    }
}
