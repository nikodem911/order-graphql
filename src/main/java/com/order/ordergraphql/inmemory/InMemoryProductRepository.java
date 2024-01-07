package com.order.ordergraphql.inmemory;

import com.order.ordergraphql.Product;
import com.order.ordergraphql.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products;

    public InMemoryProductRepository(List<Product> products) {
        this.products = List.of(
                new Product("1", "Samsung Smart TV"),
                new Product("2", "Philips Smart TV"),
                new Product("3", "Motorola Edge 40"),
                new Product("4", "Motorola Edge 30")
        );
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
                .orElse(new Product("0", "Not Found"));
    }
}
