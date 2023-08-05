package com.catchypet.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catchypet.model.entity.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long>{

}
