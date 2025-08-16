package com.BookStore.service.impl;
import com.BookStore.dto.UserRequestDTO;
import com.BookStore.dto.UserResponseDTO;
import com.BookStore.entity.Author;
import com.BookStore.entity.User;
import com.BookStore.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository bookRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository bookRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
    }

    public List<UserResponseDTO> getAllUser(){
        List<User> books = bookRepository.findAll();
        List<UserResponseDTO> bookdto = books.stream().map(book->
                {
                    UserResponseDTO dto = modelMapper.map(book, UserResponseDTO.class);
//                    if (book.getAuthorId() != null) {
//                        String authorName = book.getAuthorId().getFirst_name() + " " + book.getAuthorId().getLast_name();
//                        dto.setAuthorName(authorName);
//                    }
                    return dto;
                }
                ).collect(Collectors.toList());
        return bookdto;

    }
    public UserResponseDTO getAllUserById(Integer id){
        Optional<User> book = bookRepository.findById(id);
        UserResponseDTO bookdto = this.modelMapper.map(book, UserResponseDTO.class);
        return bookdto;
    }
    public User saveUser(UserRequestDTO b){
        User u1 = new User();
        u1.setFirst_name(b.getFirst_name());
        u1.setLast_name(b.getLast_name());
        u1.setEmail(b.getEmail());
        u1.setPhone(b.getPhone());
        u1.setAddress(b.getAddress());
        u1.setDate_of_birth(b.getDate_of_birth());
        u1.setRegistration_date(b.getRegistration_date());
        u1.setMembership_type(b.getMembership_type());
        u1.setStatus(b.getStatus());

        return bookRepository.save(u1);
    }
    public Boolean deleteUserById(Integer id){
       Optional<User> book = bookRepository.findById(id);
        if(book.isEmpty()){
            return false;
        }else {
            bookRepository.deleteById(id);
            return true;
        }
    }
}
