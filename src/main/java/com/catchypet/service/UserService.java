package com.catchypet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.catchypet.model.entity.UserEntity;
@Service
public interface UserService {
	public List<UserEntity> getAllUser();
	public UserEntity save(UserEntity user);
	public UserEntity lockAccount(Long id) throws Exception ;
	public UserEntity unlockAccount(Long id) throws Exception ;
//	    public UserDetails loadUserByUsername(String username);
	public UserEntity findById(Long id);
	public List<UserEntity> findByUsernameContaining(String key);

}
