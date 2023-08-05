package com.catchypet.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catchypet.model.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	List<CategoryEntity> findByStatusOrderByType(int status);

	List<CategoryEntity> findByStatus(int i);
}
