package com.order.ordergraphql.infrastructure.inmemory;

import com.order.ordergraphql.domain.product.Product;
import com.order.ordergraphql.domain.product.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class InMemoryProductRepository implements ProductRepository {
    private List<Product> products;

    public InMemoryProductRepository(InMemoryDB inMemoryDB) {
        this.products = inMemoryDB.getProducts();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    // TODO: handle not found
    @Override
    public Product findById(String productId) {
        return products.stream().filter(p -> p.id().equals(productId))
                .findFirst()
                .orElse(null);
    }
}
