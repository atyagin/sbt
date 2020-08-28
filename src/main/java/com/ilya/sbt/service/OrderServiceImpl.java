package com.ilya.sbt.service;

import com.ilya.sbt.domain.Client;
import com.ilya.sbt.domain.Order;
import com.ilya.sbt.dto.OrderDTO;
import com.ilya.sbt.mapper.OrderMapper;
import com.ilya.sbt.repository.ClientRepository;
import com.ilya.sbt.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final ClientRepository clientRepository;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(ClientRepository clientRepository, OrderRepository orderRepository, OrderMapper orderMapper) {
        this.clientRepository = clientRepository;
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> clientOrderList(Long clientId) {
        List<Order> clientList = orderRepository.findByClientId(clientId);
        return orderMapper.toDtoList(clientList);
    }



    @Override
    public Order saveOrder(Long clientId, Order order) {
        Client client = clientRepository.getClientById(clientId);
        order.setClient(client);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.findById(id);
        orderRepository.deleteById(id);
    }
}
