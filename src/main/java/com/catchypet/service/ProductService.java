package com.catchypet.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.catchypet.model.entity.ProductEntity;
import com.catchypet.request.Product;

import javassist.NotFoundException;

public interface ProductService {
	Page<ProductEntity> getProducts(int status, Pageable pageable);
	Product findById(Long id);
	ProductEntity save(Product product);
	ProductEntity update(Product product) throws NotFoundException;

	void delete(Long id) throws NotFoundException;
	List<ProductEntity> getProductsOnSale();
	List<ProductEntity> getFeaturesProducts();
	List<ProductEntity> getAccessories();

	
}
