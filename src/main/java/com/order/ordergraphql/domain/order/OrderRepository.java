package com.order.ordergraphql.domain.order;

import java.util.List;

public interface OrderRepository {

    List<Order> findAll();
}
