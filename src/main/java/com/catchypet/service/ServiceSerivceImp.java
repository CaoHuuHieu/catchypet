package com.catchypet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchypet.model.entity.ServiceEntity;
import com.catchypet.model.repository.ServiceRepository;
@Service
public class ServiceSerivceImp implements ServiceService {
	@Autowired
	ServiceRepository serviceRepository;
	@Override
	public List<ServiceEntity> getAllService(){
		return serviceRepository.findAll();
	}
	@Override
	public ServiceEntity findById(Long id) {
		return serviceRepository.findById(id).orElse(null);
	}
	@Override
	public ServiceEntity save(ServiceEntity serviceEntity) {
		serviceEntity.setStatus(1);
		return serviceRepository.save(serviceEntity);
	}
	@Override
	public ServiceEntity update(ServiceEntity serviceEntity) {
		return serviceRepository.save(serviceEntity);
	}
	@Override
	public void delete(Long id) {
		serviceRepository.deleteById(id);
	}
}
