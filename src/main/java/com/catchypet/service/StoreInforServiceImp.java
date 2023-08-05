package com.catchypet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchypet.model.entity.StoreInforEntity;
import com.catchypet.model.repository.StoreInforRepository;
@Service
public class StoreInforServiceImp implements StoreInforService{
	@Autowired
	private StoreInforRepository storeInforRepository;
	@Override
	public StoreInforEntity getStoreInfor() {
		return storeInforRepository.findAll().get(0);
	}

	@Override
	public StoreInforEntity update(StoreInforEntity storeInfor) {
		return storeInforRepository.save(storeInfor);
	}

}
