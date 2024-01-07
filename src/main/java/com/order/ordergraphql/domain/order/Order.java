package com.order.ordergraphql.domain.order;

import java.util.List;

public record Order(String id, List<OrderItem> orderItems) {

}
