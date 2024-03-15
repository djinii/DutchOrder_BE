package com.dutchOrder.server.controller;

import com.dutchOrder.server.dto.ShopInfoDto;
import com.dutchOrder.server.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/info")
    public ResponseEntity<List<ShopInfoDto>> getAllShopInfo() {
        List<ShopInfoDto> shopInfos = shopService.getAllShopInfo();
        return ResponseEntity.ok(shopInfos);
    }
}
