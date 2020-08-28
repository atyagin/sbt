package com.ilya.sbt.mapper;

import com.ilya.sbt.domain.Order;
import com.ilya.sbt.dto.OrderDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO toDto(Order order);
    List <OrderDTO> toDtoList(List<Order> orderList);
    Order fromDto(OrderDTO orderDTO);
}
