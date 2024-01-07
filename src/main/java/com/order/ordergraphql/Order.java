package com.order.ordergraphql;

import java.util.List;

public record Order(String id, List<OrderItem> orderItems) {

}
