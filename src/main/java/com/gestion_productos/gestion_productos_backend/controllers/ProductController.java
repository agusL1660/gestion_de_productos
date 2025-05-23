package com.gestion_productos.gestion_productos_backend.controllers;


import com.gestion_productos.gestion_productos_backend.models.entities.Product;
import com.gestion_productos.gestion_productos_backend.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;

    }

    @GetMapping("")
    public List<Product> getProducts() {
        return productService.allProducts();
    }

    @PostMapping("")
    public List<Product> addProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @PutMapping("/{id}")
    public List<Product> updateProduct(@RequestBody Product product,@PathVariable Long id) {
        return productService.updateProduct(product,id);
    }

    @DeleteMapping("/{id}")
    public List<Product> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/category/{id_cat}")
    public List<Product> getProductsByCategory(Long id_cat) {
        return productService.allProductsByCategory(id_cat);
    }
}
