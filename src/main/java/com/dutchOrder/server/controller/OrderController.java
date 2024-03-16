package com.dutchOrder.server.controller;

import com.dutchOrder.server.dto.OrderDetailsDto;
import com.dutchOrder.server.dto.OrderInfoDto;
import com.dutchOrder.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{mnum}/{bnum}/{onum}")
    public ResponseEntity<OrderDetailsDto> getOrderDetails(
            @PathVariable("mnum") Integer mnum,
            @PathVariable("bnum") Integer bnum,
            @PathVariable("onum") Integer onum) {
        OrderDetailsDto orderDetails = orderService.getOrderDetails(mnum, bnum, onum);
        return ResponseEntity.ok(orderDetails);
    }

    @GetMapping("/info/{mnum}/{bnum}/{onum}")
    public ResponseEntity<OrderInfoDto> getOrderInfo(
            @PathVariable("mnum") Integer mnum,
            @PathVariable("bnum") Integer bnum,
            @PathVariable("onum") Integer onum) {
        OrderInfoDto orderInfo = orderService.getOrderInfo(mnum, bnum, onum);
        return ResponseEntity.ok(orderInfo);
    }

    @GetMapping("/member/{mnum}")
    public ResponseEntity<List<OrderInfoDto>> getOrdersByMember(@PathVariable("mnum") Integer mnum) {
        List<OrderInfoDto> orders = orderService.getOrdersByMember(mnum);
        return ResponseEntity.ok(orders);
    }


}
