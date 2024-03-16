package com.dutchOrder.server.repository;

import com.dutchOrder.server.model.Ordering;
import com.dutchOrder.server.model.OrderingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Ordering, OrderingId> {
    List<Ordering> findAllByMnum(Integer mnum);

}
