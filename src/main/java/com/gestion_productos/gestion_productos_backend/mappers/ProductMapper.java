package com.gestion_productos.gestion_productos_backend.mappers;

import com.gestion_productos.gestion_productos_backend.models.dtos.ProductDTO;
import com.gestion_productos.gestion_productos_backend.models.entities.Product;

public class ProductMapper {

    public ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getCategory()
        );
    }

    public Product toProduct(ProductDTO productDTO){
        return new Product(
            productDTO.getId(),
            productDTO.getName(),
            productDTO.getPrice(),
            productDTO.getDescription(),
            productDTO.getCategory()
        );
    }
}
