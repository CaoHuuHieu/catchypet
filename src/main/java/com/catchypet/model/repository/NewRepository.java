package com.catchypet.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catchypet.model.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{

	List<NewEntity> findAllByOrderByCreateDate();

}
