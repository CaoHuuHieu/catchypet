package com.catchypet.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.catchypet.model.entity.ProductEntity;

public interface ProductRepository  extends JpaRepository<ProductEntity, Long>{

	Page<ProductEntity> findByStatus(int status, Pageable pageable);

	List<ProductEntity> findByType(int i);

}
