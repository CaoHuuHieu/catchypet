package com.catchypet.service;

import java.util.List;

import com.catchypet.model.entity.ServiceEntity;

public interface ServiceService {

	public List<ServiceEntity> getAllService();
	
	public ServiceEntity findById(Long id);
	
	public ServiceEntity save(ServiceEntity serviceEntity);
	public ServiceEntity update(ServiceEntity serviceEntity);
	public void delete(Long id);
}
