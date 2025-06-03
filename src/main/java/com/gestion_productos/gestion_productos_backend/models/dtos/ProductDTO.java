package com.gestion_productos.gestion_productos_backend.models.dtos;
import com.gestion_productos.gestion_productos_backend.models.entities.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ProductDTO {
    private Long id;

    private String name;
    private Double price;
    private String description;
    private Category category;
}
