package com.event.wear.platform.Rent.domain.service;

import com.event.wear.platform.Rent.domain.model.entities.Product;
import com.event.wear.platform.Rent.domain.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product.setDescription(new ProductDescription("Test Description"));
        product.setRentalPrice(100.0);

        productService.createProduct(product);

        verify(productRepository).save(any(Product.class));
    }
}