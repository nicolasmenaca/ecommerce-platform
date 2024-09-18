package com.ecommerce.platform.service;

import com.ecommerce.platform.DTO.RequestOrderDTO;
import com.ecommerce.platform.DTO.ResponseOrderDTO;
import com.ecommerce.platform.model.Order;

import java.util.Optional;

public interface OrderService {
    ResponseOrderDTO createOrder(RequestOrderDTO order);
    Iterable<Order> listAllOrders();
    Optional<Order> findOrderById(Long id);
}
