package com.order.ordergraphql.domain.customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(String id);
}
