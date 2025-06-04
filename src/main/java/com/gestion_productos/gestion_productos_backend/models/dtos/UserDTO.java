package com.gestion_productos.gestion_productos_backend.models.dtos;

import com.gestion_productos.gestion_productos_backend.models.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserDTO {
    private Long id_user;
    private String email;
    private String name;
    private String lastname;
    private String country;
    private UserRole role;
}
