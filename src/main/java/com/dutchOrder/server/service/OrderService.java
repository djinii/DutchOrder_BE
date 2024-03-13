package com.dutchOrder.server.service;

import com.dutchOrder.server.dto.OrderDetailsDto;
import com.dutchOrder.server.dto.MenuItemDto;
import com.dutchOrder.server.model.Ordering;
import com.dutchOrder.server.model.OrderSpec;
import com.dutchOrder.server.repository.OrderRepository;
import com.dutchOrder.server.repository.OrderSpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderSpecRepository orderSpecRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderSpecRepository orderSpecRepository) {
        this.orderRepository = orderRepository;
        this.orderSpecRepository = orderSpecRepository;
    }

    public OrderDetailsDto getOrderDetails(Integer onum) {
        Ordering order = orderRepository.findById(onum)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + onum));

        List<OrderSpec> orderSpecs = orderSpecRepository.findByOnum(onum);

        List<MenuItemDto> menuItems = orderSpecs.stream().map(spec -> new MenuItemDto(
                spec.getFnum(),
                "MenuItemName", 
                spec.getFcount(),
                spec.getOsprice()
        )).collect(Collectors.toList());

        String orderStatus = translateOrderStatus(order.getOStatusMaKey(), order.getOStatusMiKey());

        OrderDetailsDto orderDetailsDto = new OrderDetailsDto(
                order.getODate().toString(),
                order.getOnum(),
                orderStatus,
                menuItems,
                menuItems.stream().mapToInt(MenuItemDto::getOsPrice).sum(),
                order.getOAddr()
        );

        return orderDetailsDto;
    }

    private String translateOrderStatus(Integer oStatusMaKey, Integer oStatusMiKey) {

        return "Sample Status"; 
    }
}
