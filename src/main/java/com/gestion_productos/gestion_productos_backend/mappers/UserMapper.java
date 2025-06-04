package com.gestion_productos.gestion_productos_backend.mappers;

import com.gestion_productos.gestion_productos_backend.models.dtos.UserDTO;
import com.gestion_productos.gestion_productos_backend.models.entities.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    public  UserDTO toUserDTO(User user) {
        return new UserDTO(
            user.getId_user(),
                user.getName(),
                user.getEmail(),
                user.getCountry(),
                user.getLastname(),
                user.getRole()
        );
    }

}
