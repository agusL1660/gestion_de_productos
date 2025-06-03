package com.gestion_productos.gestion_productos_backend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_cat")
    private Category category;
}
