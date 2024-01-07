package com.order.ordergraphql;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;

    @QueryMapping
    List<Order> orders() {
        return orderRepository.findAll();
    }
}
