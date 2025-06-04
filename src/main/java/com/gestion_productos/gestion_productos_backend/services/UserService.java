package com.gestion_productos.gestion_productos_backend.services;


import com.gestion_productos.gestion_productos_backend.mappers.ProductMapper;
import com.gestion_productos.gestion_productos_backend.mappers.UserMapper;
import com.gestion_productos.gestion_productos_backend.models.dtos.UserDTO;
import com.gestion_productos.gestion_productos_backend.models.entities.Product;
import com.gestion_productos.gestion_productos_backend.models.entities.User;
import com.gestion_productos.gestion_productos_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository,UserMapper userMapper){
        this.userRepository=userRepository;
        this.userMapper=userMapper;
    }

    public UserDTO getUser(Long id_user) {
        return userRepository.findById(id_user).map(userMapper::toUserDTO).orElseThrow();
    }

    public UserDTO addUser(User user) {
        userRepository.save(user);
        return userRepository.findById(user.getId_user()).map(userMapper::toUserDTO).orElseThrow();
    }

    public UserDTO updateUser(User user,Long id) {

        User userToUpdate= userRepository.findById(id).orElseThrow();
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setCountry(user.getCountry());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setRole(user.getRole());

        return userRepository.findById(id).map(userMapper::toUserDTO).orElseThrow();
    }

    public List<UserDTO> allUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserDTO).collect(Collectors.toList());
    }
}
