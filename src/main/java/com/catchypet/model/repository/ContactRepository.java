package com.catchypet.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.catchypet.model.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Long>{
	Page<ContactEntity> findAllByOrderByCreateDate(Pageable page);

}
