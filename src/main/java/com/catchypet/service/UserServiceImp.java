package com.catchypet.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchypet.model.entity.UserEntity;
import com.catchypet.model.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity save(UserEntity user) {
		user.setStatus(0);
		user.setCreateDate(Date.valueOf(LocalDate.now()));
		return userRepository.save(user);
	}

	@Override
	public UserEntity lockAccount(Long id) throws Exception {
		UserEntity userEntity = userRepository.findById(id)
				.orElseThrow(() -> new Exception("Không tìm thấy tài khoản"));
		userEntity.setStatus(1);
		return userRepository.save(userEntity);
	}

	@Override
	public UserEntity unlockAccount(Long id) throws Exception {
		UserEntity userEntity = userRepository.findById(id)
				.orElseThrow(() -> new Exception("Không tìm thấy tài khoản"));
		userEntity.setStatus(0);
		userEntity.setCreateDate(Date.valueOf(LocalDate.now()));
		return userRepository.save(userEntity);
	}

	public UserEntity findById(Long id) {
		return userRepository.findById(id).orElse(null);

	}
	public List<UserEntity> findByUsernameContaining(String key) {
		return userRepository.findByUsernameContaining(key);
	}
}
