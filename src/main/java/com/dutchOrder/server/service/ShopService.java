package com.dutchOrder.server.service;

import com.dutchOrder.server.dto.ShopInfoDto;
import com.dutchOrder.server.model.Shop;
import com.dutchOrder.server.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopInfoDto> getAllShopInfo() {
        List<Shop> shops = shopRepository.findAll();
        return shops.stream()
                .map(shop -> new ShopInfoDto(shop.getSname(), shop.getSimg1(), shop.getStel()))
                .collect(Collectors.toList());
    }
}
