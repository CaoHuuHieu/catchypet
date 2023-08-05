package com.catchypet.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchypet.model.entity.BookingEntity;
import com.catchypet.model.repository.BookingRepository;
@Service
public class BookingServiceImp implements BookingService{
	@Autowired 
	BookingRepository bookingRepository;
	@Override
	public List<BookingEntity> getAllBooking() {
		return bookingRepository.findAll();
	}
	
	@Override
	public BookingEntity save(BookingEntity booking) {
		booking.setCreateDate(Date.valueOf(LocalDate.now()));
		booking.setStatus(0);
		return bookingRepository.save(booking);
	}

	@Override
	public BookingEntity updateStatus(Long id) {
		BookingEntity booking =  bookingRepository.findById(id).get();
		booking.setStatus(1);
		return bookingRepository.save(booking);
	}

	@Override
	public void detele(Long id) {
		bookingRepository.deleteById(id);
	}

	@Override
	public BookingEntity findById(Long id) {
		return bookingRepository.findById(id).orElse(null);
	}

}
