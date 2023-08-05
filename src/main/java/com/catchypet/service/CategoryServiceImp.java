package com.catchypet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchypet.model.entity.CategoryEntity;
import com.catchypet.model.repository.CategoryRepository;
import com.catchypet.request.Category;
@Service
public class CategoryServiceImp implements CategoryService{
	@Autowired 
	CategoryRepository categoryRepository;
	@Autowired 
	ImageStorageService imageStorageService;
	@Override
	public List<CategoryEntity> getCategoryForProduct() {
		return categoryRepository.findByStatus(0);
	}

	@Override
	public List<CategoryEntity> getCategoryForNew() {
		
		return categoryRepository.findByStatus(1);
	}

	@Override
	public List<CategoryEntity> getAllCategory() {
		return categoryRepository.findByStatusOrderByType(0);
	}
	@Override
	public CategoryEntity findById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public CategoryEntity save(Category category) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName(category.getName());
		categoryEntity.setDescription(category.getDescription());
		categoryEntity.setStatus(0);
		categoryEntity.setType(category.getType());
		if(category.getFile() != null && !category.getFile().isEmpty()) {
			String fileName = imageStorageService.storeFile(category.getFile());
			categoryEntity.setFileName(fileName);
		}
		
		return categoryRepository.save(categoryEntity);
	}

	@Override
	public CategoryEntity update(Long id, Category category) {
		CategoryEntity categoryEntity = findById(id);
		if(categoryEntity != null) {
			categoryEntity.setName(category.getName());
			categoryEntity.setDescription(category.getDescription());
			categoryEntity.setType(category.getType());
			if(category.getFile() != null && !category.getFile().isEmpty()) {
				String fileName = imageStorageService.storeFile(category.getFile());
				categoryEntity.setFileName(fileName);
			}
			return categoryRepository.save(categoryEntity);
		}
		return null;
	}

	@Override
	public CategoryEntity delete(Long id) {
		CategoryEntity categoryEntity = findById(id);
		if(categoryEntity != null) {
			categoryEntity.setStatus(1);
			return categoryRepository.save(categoryEntity);
		}
		return null;
	}

	

}
