package com.order.ordergraphql.domain.customer;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
    private List<Customer> customers;

    public InMemoryCustomerRepository() {
        this.customers = List.of(
                new Customer("1", "Bruce", "Wayne"),
                new Customer("2", "Peter", "Parker"),
                new Customer("3", "John", "Rambo"));
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(String id) {
        return customers.stream().filter(c -> c.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
