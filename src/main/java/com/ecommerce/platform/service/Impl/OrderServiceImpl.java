package com.ecommerce.platform.service.Impl;

import com.ecommerce.platform.DTO.ProductOrderDTO;
import com.ecommerce.platform.DTO.RequestOrderDto;
import com.ecommerce.platform.DTO.ResponseOrderDTO;
import com.ecommerce.platform.model.Order;
import com.ecommerce.platform.model.Product;
import com.ecommerce.platform.repository.OrderRepository;
import com.ecommerce.platform.repository.ProductRepository;
import com.ecommerce.platform.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;



    @Override
    @Transactional
    public ResponseOrderDTO createOrder(RequestOrderDto order)  {
        List<Product> products = new ArrayList<>();
        Order oneOrder = new Order();
        Double totalVenta = 0.0;
        for(ProductOrderDTO prod: order.getListProducts()) {
            Product oneProduct = productRepository.findById(prod.getId()).orElse(new Product());
            if(oneProduct != null && oneProduct.getStock() >= prod.getQuantityAmount()){
                oneProduct.setStock(oneProduct.getStock()-prod.getQuantityAmount());
                totalVenta += oneProduct.getCost()*prod.getQuantityAmount();
                products.add(oneProduct);
                productRepository.save(oneProduct);
            } else {
                ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
                responseOrderDTO.setMessage("El producto no existe o no tiene esta cantidad en el stock");
                responseOrderDTO.setOrderNumber("0");
                return responseOrderDTO;
            }

        }
        oneOrder.setOrderDate(new Date());
        oneOrder.setTotalAmount(totalVenta);
        oneOrder.setProduct(products);
        oneOrder.setCustomerId(order.getIdCustomer());
        oneOrder = orderRepository.save(oneOrder);
        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
        responseOrderDTO.setMessage("Se genero la orden de venta correctamente");
        responseOrderDTO.setOrderNumber(oneOrder.getId().toString());
        return responseOrderDTO;

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
