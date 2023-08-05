package com.catchypet.service;

import java.util.List;

import com.catchypet.model.entity.BookingEntity;

public interface BookingService {
	public List<BookingEntity> getAllBooking();
	public BookingEntity findById(Long id);
	public BookingEntity save(BookingEntity booking);
	public BookingEntity updateStatus(Long id);
	public void detele(Long id);
}
