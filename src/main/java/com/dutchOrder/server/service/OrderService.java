package com.dutchOrder.server.service;

import com.dutchOrder.server.dto.OrderDetailsDto;
import com.dutchOrder.server.dto.MenuItemDto;
import com.dutchOrder.server.dto.OrderInfoDto;
import com.dutchOrder.server.model.*;
import com.dutchOrder.server.repository.MenuRepository;
import com.dutchOrder.server.repository.OrderRepository;
import com.dutchOrder.server.repository.OrderSpecRepository;
import com.dutchOrder.server.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.sql.Timestamp;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderSpecRepository orderSpecRepository;
    private final MenuRepository menuRepository;
    private final ShopRepository shopRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderSpecRepository orderSpecRepository, MenuRepository menuRepository, ShopRepository shopRepository) {
        this.orderRepository = orderRepository;
        this.orderSpecRepository = orderSpecRepository;
        this.menuRepository = menuRepository;
        this.shopRepository = shopRepository;
    }

    public OrderDetailsDto getOrderDetails(Integer mnum, Integer bnum, Integer onum) {
            OrderingId orderId = new OrderingId(mnum, bnum, onum);
            Ordering order = orderRepository.findById(orderId)
                    .orElseThrow(() -> new RuntimeException("Order not found"));

            List<OrderSpec> orderSpecs = orderSpecRepository.findByOnum(order.getOnum());


        List<MenuItemDto> menuItems = orderSpecs.stream().flatMap(spec -> {
            Integer orderBnum = order.getBnum();
            System.out.println("orderbum"+orderBnum + " "+ "specFnum"+" " + spec.getFnum());

            // 복합 키 객체 생성
            MenuId menuId = new MenuId(orderBnum, spec.getFnum());

            // 생성한 복합 키 객체를 사용하여 Menu 엔티티 조회
            return menuRepository.findById(menuId).map(menu ->
                    Stream.of(new MenuItemDto(spec.getFnum(), menu.getFname(), spec.getFcount(), spec.getOsprice()))
            ).orElseGet(Stream::empty); // 데이터가 없으면 빈 스트림 반환
        }).collect(Collectors.toList());


            String orderStatus = translateOrderStatus(order.getOstatusMiKey());
            String oDateStr = order.getOdate() != null ? order.getOdate().toString() : "날짜 정보 없음";

            return new OrderDetailsDto(
                    oDateStr,
                    order.getOnum(),
                    orderStatus,
                    menuItems,
                    menuItems.stream().mapToInt(MenuItemDto::getOsprice).sum(),
                    order.getOaddr()
            );
        }

    private String translateOrderStatus(Integer oStatus) {
        System.out.println("ostatus: " + oStatus);
        // 상태 번호에 따른 상태 문자열 변환 로직 구현
        switch (oStatus) {
            case 801: return "장바구니";
            case 802: return "주문수락대기";
            case 803: return "조리중";
            case 804: return "배달시작";
            case 805: return "배달완료";
            default: return "알 수 없음";
        }
        
    }

    public OrderInfoDto getOrderInfo(Integer mnum, Integer bnum, Integer onum) {
        Ordering ordering = orderRepository.findById(new OrderingId(mnum, bnum, onum))
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Shop shop = shopRepository.findById(bnum)
                .orElseThrow(() -> new RuntimeException("Shop not found"));

        List<OrderSpec> orderSpecs = orderSpecRepository.findByOnum(onum);
        List<MenuItemDto> menuItems = orderSpecs.stream().flatMap(spec -> {
            MenuId menuId = new MenuId(ordering.getBnum(), spec.getFnum());
            return menuRepository.findById(menuId).map(menu ->
                    Stream.of(new MenuItemDto(spec.getFnum(), menu.getFname(), spec.getFcount(), spec.getOsprice()))
            ).orElseGet(() -> {
                System.out.println("Menu item not found for bnum: " + ordering.getBnum() + ", fnum: " + spec.getFnum());
                return Stream.empty();
            });
        }).collect(Collectors.toList());

        Integer totalAmount = menuItems.stream().mapToInt(MenuItemDto::getOsprice).sum();

        String formattedDate = Optional.ofNullable(ordering.getOdate())
                .map(Timestamp::toLocalDateTime)
                .map(localDateTime -> localDateTime.toString())
                .orElse("날짜 정보 없음");

        return new OrderInfoDto(
                shop.getSname(),
                ordering.getOnum(),
                formattedDate,
                menuItems,
                totalAmount,
                ordering.getOaddr(),
                ordering.getOmsg()
        );
    }


    public List<OrderInfoDto> getOrdersByMember(Integer mnum) {
        List<Ordering> orders = orderRepository.findAllByMnum(mnum);

        return orders.stream().map(order -> {
            Shop shop = shopRepository.findById(order.getBnum())
                    .orElseThrow(() -> new RuntimeException("Shop not found for order: " + order.getOnum()));

            List<OrderSpec> orderSpecs = orderSpecRepository.findByOnum(order.getOnum());
            List<MenuItemDto> menuItems = orderSpecs.stream().flatMap(spec -> {
                MenuId menuId = new MenuId(order.getBnum(), spec.getFnum());
                return menuRepository.findById(menuId).map(menu ->
                        Stream.of(new MenuItemDto(spec.getFnum(), menu.getFname(), spec.getFcount(), spec.getOsprice()))
                ).orElseGet(() -> {
                    System.out.println("Menu item not found for bnum: " + order.getBnum() + ", fnum: " + spec.getFnum());
                    return Stream.empty();
                });
            }).collect(Collectors.toList());


            Integer totalAmount = menuItems.stream().mapToInt(MenuItemDto::getOsprice).sum();

            String formattedDate = Optional.ofNullable(order.getOdate())
                    .map(Timestamp::toLocalDateTime)
                    .map(localDateTime -> localDateTime.toString())
                    .orElse("날짜 정보 없음");

            return new OrderInfoDto(
                    shop.getSname(),
                    order.getOnum(),
                    formattedDate,
                    menuItems,
                    totalAmount,
                    order.getOaddr(),
                    order.getOmsg()
            );
        }).collect(Collectors.toList());
    }

}
