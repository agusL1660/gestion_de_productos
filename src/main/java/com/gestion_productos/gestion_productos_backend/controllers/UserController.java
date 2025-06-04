package com.gestion_productos.gestion_productos_backend.controllers;

import com.gestion_productos.gestion_productos_backend.models.dtos.ProductDTO;
import com.gestion_productos.gestion_productos_backend.models.dtos.UserDTO;
import com.gestion_productos.gestion_productos_backend.models.entities.Product;
import com.gestion_productos.gestion_productos_backend.models.entities.User;
import com.gestion_productos.gestion_productos_backend.services.ProductService;
import com.gestion_productos.gestion_productos_backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id_user) {
        return ResponseEntity.ok(userService.getUser(id_user));
    }

    @PostMapping()
    public ResponseEntity<UserDTO>  addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping()
    public ResponseEntity<UserDTO> updateUser(@RequestBody User user,@RequestBody Long id) {
        return ResponseEntity.ok(userService.updateUser(user,id));
    }

    @GetMapping()
    public List<UserDTO> allUsers() {
        return userService.allUsers();
    }


}
