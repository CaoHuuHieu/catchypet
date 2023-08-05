package com.catchypet.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.catchypet.model.entity.ContactEntity;
import com.catchypet.model.repository.ContactRepository;

@Service
public class ContactServiceImp implements ContactService{
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Page<ContactEntity> getAllContact(Pageable page) {
		return contactRepository.findAllByOrderByCreateDate(page);
	}
	@Override
	public ContactEntity getContactById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactEntity save(ContactEntity contact) {
		contact.setCreateDate(Date.valueOf(LocalDate.now()));
		contact.setStatus(0);
		return contactRepository.save(contact);
	}

	@Override
	public ContactEntity update(Long id) {
		ContactEntity contact = contactRepository.findById(id).get();
		contact.setStatus(1);
		return contactRepository.save(contact);
	}

	@Override
	public void delete(Long id) {
		contactRepository.deleteById(id);
	}
	
}
