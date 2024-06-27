package com.event.wear.platform.transactions.application.internal.queryservices;

import com.event.wear.platform.transactions.domain.model.entities.ProductItem;
import com.event.wear.platform.transactions.domain.model.queries.GetProductItemByIdQuery;
import com.event.wear.platform.transactions.domain.services.ProductItemQueryService;
import com.event.wear.platform.transactions.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductItemQueryServiceImpl implements ProductItemQueryService {

    private final ProductRepository productRepository;

    public ProductItemQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<ProductItem> handle(GetProductItemByIdQuery query){
        return productRepository.findById(query.productId().productId());
    }
}
