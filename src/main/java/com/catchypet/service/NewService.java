package com.catchypet.service;

import java.util.List;

import com.catchypet.model.entity.NewEntity;
import com.catchypet.request.NewDTO;

public interface NewService {
	public List<NewEntity> getAllNew();
	public NewDTO getNewById(Long id);
	public NewEntity save(NewDTO newDto);
	public NewEntity update(Long id, NewDTO newDto);
	public void delete(Long id);
}
