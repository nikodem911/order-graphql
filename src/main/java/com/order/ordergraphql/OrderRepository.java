package com.order.ordergraphql;

import java.util.List;

public interface OrderRepository {

    List<Order> findAll();
}
