package com.order.ordergraphql;

import com.order.ordergraphql.domain.order.Order;
import com.order.ordergraphql.domain.order.OrderItem;
import com.order.ordergraphql.domain.order.OrderRepository;
import com.order.ordergraphql.domain.product.Product;
import com.order.ordergraphql.domain.product.ProductRepository;
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

    @QueryMapping
    public List<Product> products() {
        return productRepository.findAll();
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
