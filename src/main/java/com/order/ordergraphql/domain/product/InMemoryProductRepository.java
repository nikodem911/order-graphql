package com.order.ordergraphql.domain.product;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class InMemoryProductRepository implements ProductRepository {
    private List<Product> products;

    public InMemoryProductRepository(List<Product> products) {
        this.products = List.of(
                new Product("1", "Samsung Smart TV", "4123458778932", 99.99),
                new Product("2", "Philips Smart TV", "4123458553112", 89.99),
                new Product("3", "Motorola Edge 40", "4143265522111", 119.99),
                new Product("4", "Motorola Edge 30", "4143265522122", 99.99)
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
                .orElse(null);
    }
}
