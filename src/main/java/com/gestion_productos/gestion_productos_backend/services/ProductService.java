package com.gestion_productos.gestion_productos_backend.services;

import com.gestion_productos.gestion_productos_backend.mappers.ProductMapper;
import com.gestion_productos.gestion_productos_backend.models.dtos.ProductDTO;
import com.gestion_productos.gestion_productos_backend.models.entities.Category;
import com.gestion_productos.gestion_productos_backend.models.entities.Product;
import com.gestion_productos.gestion_productos_backend.repositories.CategoryRepository;
import com.gestion_productos.gestion_productos_backend.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    private ProductMapper productMapper;


    public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository,ProductMapper productMapper){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
        this.productMapper=productMapper;
    }
    public List<ProductDTO> allProducts(){

        return productRepository.findAll().stream().map(productMapper::toProductDTO).collect(Collectors.toList());
    }

    public List<ProductDTO> insertProduct(Product product) {
        productRepository.save(product);
        return productRepository.findAll().stream().map(productMapper::toProductDTO).collect(Collectors.toList());
    }

    public List<ProductDTO> deleteProduct(Long id) {
        Product product=productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
        return productRepository.findAll().stream().map(productMapper::toProductDTO).collect(Collectors.toList());

    }
    public List<ProductDTO> updateProduct(Product product, Long id) {
        Product productToUpdate=productRepository.findById(id).orElseThrow();
        productToUpdate.setCategory(product.getCategory());
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());

        return productRepository.findAll().stream().map(productMapper::toProductDTO).collect(Collectors.toList());
    }

    public List<ProductDTO> allProductsByCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return productRepository.findByCategory(category).stream().map(productMapper::toProductDTO).collect(Collectors.toList());
    }
}
