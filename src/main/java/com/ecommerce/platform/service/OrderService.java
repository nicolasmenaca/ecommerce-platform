package com.ecommerce.platform.service;

import com.ecommerce.platform.model.Order;

import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);
    Iterable<Order> listAllOrders();
    Optional<Order> findOrderById(Long id);
}
