package com.catchypet.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catchypet.model.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

}
