package com.ecommerce.platform.DTO;

import lombok.Data;

import java.util.List;

@Data
public class RequestOrderDto {
    private String orderDate;
    private Long idCustomer;
    private List<ProductOrderDTO> listProducts;
}
