package com.order.ordergraphql;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    Product findById(String productId);
}
