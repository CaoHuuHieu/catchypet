package com.catchypet.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catchypet.model.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
