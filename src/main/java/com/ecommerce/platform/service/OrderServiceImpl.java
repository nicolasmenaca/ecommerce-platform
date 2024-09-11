package com.ecommerce.platform.service;

import com.ecommerce.platform.model.Order;
import com.ecommerce.platform.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        try {
            return orderRepository.save(order);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar la orden en la base de datos", e);
        }
    }

    @Override
    public Iterable<Order> listAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findOrderById(Long id) {
        return orderRepository.findById(id);
    }
}
