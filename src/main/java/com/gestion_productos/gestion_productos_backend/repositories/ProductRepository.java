package com.gestion_productos.gestion_productos_backend.repositories;

import com.gestion_productos.gestion_productos_backend.models.entities.Category;
import com.gestion_productos.gestion_productos_backend.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    public List<Product> findByCategory(Category category);
}
