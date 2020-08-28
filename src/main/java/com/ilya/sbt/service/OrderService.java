package com.ilya.sbt.service;

import com.ilya.sbt.domain.Order;
import com.ilya.sbt.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> clientOrderList(Long clientId);
    Order saveOrder(Long clientId, Order order);
    void deleteOrder(Long id);
}
