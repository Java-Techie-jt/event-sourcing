package com.javatechie.repository;

import com.javatechie.entity.OrderEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderEventRepository extends MongoRepository<OrderEvent,String> {
}
