package com.dutchOrder.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.MenuId;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, MenuId> {
}
