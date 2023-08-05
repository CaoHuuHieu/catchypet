package com.catchypet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.catchypet.model.entity.ContactEntity;

public interface ContactService {
	public Page<ContactEntity> getAllContact(Pageable page);
	public ContactEntity getContactById();
	public ContactEntity save(ContactEntity contact);
	public ContactEntity update(Long id);
	public void delete(Long id);
}
