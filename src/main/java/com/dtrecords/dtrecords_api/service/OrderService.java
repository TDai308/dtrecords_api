package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Artist;
import com.dtrecords.dtrecords_api.domain.Order;

import java.util.Optional;

public interface OrderService extends GeneralService<Order>{
    Iterable<Order> findAll();

    Optional<Order> findById(Long id);

    void save(Order order);

    void remove(Long id);
}
