package com.catchypet.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catchypet.model.entity.UserEntity;
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	List<UserEntity> findByUsernameContaining(String key);
}
