package com.order.ordergraphql.inmemory;

import com.order.ordergraphql.Order;
import com.order.ordergraphql.OrderItem;
import com.order.ordergraphql.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

    private List<Order> orders;

    public InMemoryOrderRepository() {
        this.orders = List.of(
                new Order("order1", List.of(
                        new OrderItem("1", "1"),
                        new OrderItem("2", "3"))),
                new Order("order1", List.of(
                        new OrderItem("1", "2")))
        );
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }
}
