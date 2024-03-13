package com.dutchOrder.server.controller;

import com.dutchOrder.server.dto.OrderDetailsDto;
import com.dutchOrder.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{onum}")
    public ResponseEntity<OrderDetailsDto> getOrderDetails(@PathVariable("onum") Integer onum) {
        OrderDetailsDto orderDetails = orderService.getOrderDetails(onum);
        return ResponseEntity.ok(orderDetails);
    }

}
