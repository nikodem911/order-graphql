package com.order.ordergraphql.infrastructure.inmemory;

import com.order.ordergraphql.domain.order.Order;
import com.order.ordergraphql.domain.order.OrderItem;
import com.order.ordergraphql.domain.order.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class InMemoryOrderRepository implements OrderRepository {

    private final List<Order> orders;

    public InMemoryOrderRepository(InMemoryDB inMemoryDB) {
        this.orders = inMemoryDB.getOrders();
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public List<Order> findByIdSubstring(String substring) {
        return orders.stream()
                .filter(order -> order.id().contains(substring))
                .toList();
    }
}
