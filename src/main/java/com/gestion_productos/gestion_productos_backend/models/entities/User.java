package com.gestion_productos.gestion_productos_backend.models.entities;

import com.gestion_productos.gestion_productos_backend.models.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Setter
@Getter
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String email;
    private String name;
    private String lastname;
    private String country;
    private UserRole role;
}
