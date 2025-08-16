package com.BookStore.service;

import com.BookStore.dto.UserRequestDTO;
import com.BookStore.dto.UserResponseDTO;
import com.BookStore.entity.User;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getAllUser();
    UserResponseDTO getAllUserById(Long id);
    User saveUser(UserRequestDTO b);
    Boolean deleteUserById(Long id);

}
