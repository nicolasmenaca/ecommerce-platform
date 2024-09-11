package com.ecommerce.platform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "customer_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long customerId; // ID del cliente que realizó la orden

    @Column(nullable = false)
    private LocalDate orderDate; // Fecha de la orden

    @Column(nullable = false)
    private Double totalAmount; // Monto total de la orden

    // Otros campos que consideres necesarios, como estado de la orden, dirección de envío, etc.
}



