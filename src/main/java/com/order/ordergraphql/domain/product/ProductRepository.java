package com.order.ordergraphql.domain.product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    Product findById(String productId);
}
