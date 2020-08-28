package com.ilya.sbt.controller;

import com.ilya.sbt.domain.Order;
import com.ilya.sbt.dto.OrderDTO;
import com.ilya.sbt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/clients/{clientId}/orders/")
    public ResponseEntity<List<OrderDTO>> getClientOrders(@PathVariable(value = "clientId") Long clientId, Pageable pageable) {
        List<OrderDTO> clientOrdersDTOList = orderService.clientOrderList(clientId);

        if (clientOrdersDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(clientOrdersDTOList, HttpStatus.OK);
    }

    @PostMapping("/clients/{clientId}/orders/")
    public ResponseEntity<Order> addClientOrder(@PathVariable (value = "clientId") Long clientId, @Valid @RequestBody Order order) {
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        orderService.saveOrder(clientId, order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("/clients/{clientId}/orders/")
    public ResponseEntity<Order> updateClientOrder(@PathVariable (value = "clientId") Long clientId, @Valid @RequestBody Order order) {
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        orderService.saveOrder(clientId, order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteClientOrder(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
