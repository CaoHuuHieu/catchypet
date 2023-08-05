package com.catchypet.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchypet.model.entity.NewEntity;
import com.catchypet.model.repository.NewRepository;
import com.catchypet.request.NewDTO;

@Service
public class NewServiceImp implements NewService{
	@Autowired
	private NewRepository newRepository;
	@Autowired
	private IStorageService iStorageService;
	@Override
	public List<NewEntity> getAllNew() {
		return newRepository.findAllByOrderByCreateDate();
	}

	@Override
	public NewDTO getNewById(Long id) {
		NewEntity newEntity = newRepository.findById(id).get();
		NewDTO newDto = new NewDTO();
		newDto.setId(newEntity.getId());
		newDto.setHeading(newEntity.getHeading());
		newDto.setContent(newEntity.getContent());
		newDto.setImage(newEntity.getImage());
		newDto.setShortDescription(newEntity.getShortDescription());
		return newDto;
	}

	@Override
	public NewEntity save(NewDTO newDto) {
		NewEntity newEntity = new NewEntity();
		newEntity.setHeading(newDto.getHeading());
		newEntity.setShortDescription(newDto.getShortDescription());
		newEntity.setContent(newDto.getContent());
		newEntity.setCreateDate(Date.valueOf(LocalDate.now()));
		newEntity.setStatus(0);
		if(!newDto.getFile().isEmpty()) {
			String fileName = iStorageService.storeFile(newDto.getFile());
			newEntity.setImage(fileName);
		}
		return newRepository.save(newEntity);
	}

	@Override
	public NewEntity update(Long id, NewDTO newDto) {
		NewEntity newEntity = newRepository.findById(id).get();
		newEntity.setHeading(newDto.getHeading());
		newEntity.setShortDescription(newDto.getShortDescription());
		newEntity.setContent(newDto.getContent());
		if(!newDto.getFile().isEmpty()) {
			String fileName = iStorageService.storeFile(newDto.getFile());
			newEntity.setImage(fileName);
		}
		return newRepository.save(newEntity);
	}

	@Override
	public void delete(Long id) {
		newRepository.deleteById(id);
	}

}
