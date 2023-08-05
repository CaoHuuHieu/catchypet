package com.catchypet.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catchypet.model.entity.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long>{

}
