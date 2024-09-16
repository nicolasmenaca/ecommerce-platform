package com.ecommerce.platform.controller;

import com.ecommerce.platform.DTO.OrderDto;
import com.ecommerce.platform.DTO.RequestOrderDto;
import com.ecommerce.platform.DTO.ResponseOrderDTO;
import com.ecommerce.platform.model.Order;
import com.ecommerce.platform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:4200")
public class orderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/neworder")
    public ResponseOrderDTO createOrder(@RequestBody RequestOrderDto orderDto) {
        ResponseOrderDTO responseOrderDTO = orderService.createOrder(orderDto);
        return responseOrderDTO;
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Order>> listOrders() {
        return ResponseEntity.ok(orderService.listAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

