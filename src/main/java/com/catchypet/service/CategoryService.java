package com.catchypet.service;

import java.util.List;

import com.catchypet.model.entity.CategoryEntity;
import com.catchypet.request.Category;

public interface CategoryService {
	List<CategoryEntity> getCategoryForProduct();
	List<CategoryEntity> getCategoryForNew();
	CategoryEntity findById(Long id);
	CategoryEntity save(Category category);
	CategoryEntity update(Long id, Category category);
	CategoryEntity delete(Long id);
	List<CategoryEntity> getAllCategory();
} 
