package com.javatechie.service;

import com.javatechie.dto.enums.OrderStatus;
import com.javatechie.entity.OrderEvent;
import com.javatechie.repository.OrderEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShippingEventService {

    @Autowired
    private OrderEventRepository repository;


    @KafkaListener(topics = "order-events", groupId = "shipping-service")
    public void consumeOrderEvent(OrderEvent orderEvent) {
        if (orderEvent.getStatus().equals(OrderStatus.CONFIRMED)) {
            // Automatically ship after order confirmation
            shipOrder(orderEvent.getOrderId());
        }
    }


    // Ship the order
    public void shipOrder(String orderId) {
        OrderEvent orderEvent = new OrderEvent(orderId, OrderStatus.SHIPPED, "Order Shipped successfully", LocalDateTime.now());
        repository.save(orderEvent);
    }

    // Deliver the order
    public void deliverOrder(String orderId) {
        OrderEvent orderEvent = new OrderEvent(orderId, OrderStatus.DELIVERED, "Order delivered successfully", LocalDateTime.now());
        repository.save(orderEvent);
    }

    private void saveAndPublishShippingEvent(Object event) {

    }
}
