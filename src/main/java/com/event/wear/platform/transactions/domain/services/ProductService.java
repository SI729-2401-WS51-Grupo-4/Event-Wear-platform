package com.event.wear.platform.transactions.domain.services;

import com.event.wear.platform.transactions.domain.model.entities.Product;
import com.event.wear.platform.transactions.domain.model.valueobjects.ProductDescription;
import com.event.wear.platform.transactions.domain.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setRentalPrice(productDetails.getRentalPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        Product product = new Product();
        product.setName("Test Product");
        product.setDescription(new ProductDescription("Test Description"));
        product.setRentalPrice(100.0);

        createProduct(product);
    }

}