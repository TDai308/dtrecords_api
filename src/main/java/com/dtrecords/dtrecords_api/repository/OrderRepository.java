package com.dtrecords.dtrecords_api.repository;

import com.dtrecords.dtrecords_api.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
