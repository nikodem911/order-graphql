package com.order.ordergraphql;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class OrderController {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @QueryMapping
    public List<Order> orders() {
        return orderRepository.findAll();
    }

    @SchemaMapping
    public List<OrderItem> items(Order order) {
        return order.orderItems();
    }

    @SchemaMapping
    public Product product(OrderItem item) {
        return productRepository.findById(item.productId());
    }
}
