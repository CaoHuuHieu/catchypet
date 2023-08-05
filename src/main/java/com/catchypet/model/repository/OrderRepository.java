package com.catchypet.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catchypet.model.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
