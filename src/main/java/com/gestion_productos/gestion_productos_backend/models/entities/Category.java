package com.gestion_productos.gestion_productos_backend.models.entities;

import com.gestion_productos.gestion_productos_backend.models.enums.CategoryName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cat;

    @Enumerated(EnumType.STRING)
    private CategoryName name;
}
