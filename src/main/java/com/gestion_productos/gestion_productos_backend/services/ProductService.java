package com.gestion_productos.gestion_productos_backend.services;

import com.gestion_productos.gestion_productos_backend.models.entities.Category;
import com.gestion_productos.gestion_productos_backend.models.entities.Product;
import com.gestion_productos.gestion_productos_backend.repositories.CategoryRepository;
import com.gestion_productos.gestion_productos_backend.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }
    public List<Product> allProducts(){
        return productRepository.findAll();
    }

    public List<Product> insertProduct(Product product) {
        productRepository.save(product);
        return productRepository.findAll();
    }

    public List<Product> deleteProduct(Long id) {
        Product product=productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
        return productRepository.findAll();

    }
    public List<Product> updateProduct(Product product, Long id) {
        Product productToUpdate=productRepository.findById(id).orElseThrow();
        productToUpdate.setCategory(product.getCategory());
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());

        return productRepository.findAll();
    }

    public List<Product> allProductsByCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return productRepository.findByCategory(category);
    }
}
