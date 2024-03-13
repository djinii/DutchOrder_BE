package com.dutchOrder.server.repository;

import com.dutchOrder.server.model.OrderSpec;
import com.dutchOrder.server.model.OrderSpecId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderSpecRepository extends JpaRepository<OrderSpec, OrderSpecId> {

    List<OrderSpec> findByOnum(Integer onum);

}
