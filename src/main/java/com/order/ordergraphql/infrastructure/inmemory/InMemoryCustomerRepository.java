package com.order.ordergraphql.infrastructure.inmemory;

import com.order.ordergraphql.domain.customer.Customer;
import com.order.ordergraphql.domain.customer.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class InMemoryCustomerRepository implements CustomerRepository {
    private final List<Customer> customers;

    public InMemoryCustomerRepository(InMemoryDB inMemoryDB) {
        this.customers = inMemoryDB.getCustomers();
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(String id) {
        return customers.stream().filter(c -> c.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
