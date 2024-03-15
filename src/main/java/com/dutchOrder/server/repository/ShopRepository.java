package com.dutchOrder.server.repository;

import com.dutchOrder.server.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
