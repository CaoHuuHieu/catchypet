package com.catchypet.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.catchypet.State;
import com.catchypet.model.entity.ProductEntity;
import com.catchypet.model.repository.CategoryRepository;
import com.catchypet.model.repository.ProductRepository;
import com.catchypet.request.Product;

import jakarta.transaction.Status;
import javassist.NotFoundException;
@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository 	categoryRepository;
	@Autowired 
	ImageStorageService imageStorageService;
	@Override
	public Page<ProductEntity> getProducts(int status, Pageable pageable) {
		return productRepository.findByStatus(status, pageable);
	}

	@Override
	public Product findById(Long id) {
		ProductEntity productEntity = productRepository.findById(id).orElse(null);
		if(productEntity != null) {
			Product product  = new Product();
			product.setId(productEntity.getId());
			product.setName(productEntity.getName());
			product.setBrand(productEntity.getBrand());
			product.setQuantity(productEntity.getQuantity());
			product.setDescription(productEntity.getDescription());
			product.setDefaultPrice(productEntity.getDefaultPrice());
			product.setSellPrice(productEntity.getSellPrice());
			product.setCategory(productEntity.getCategory().getId());
			product.setImages(productEntity.getImage());
			return product;
		}
		return null;
	
	}

	@Override
	public ProductEntity save(Product product) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(product.getName());
		productEntity.setDescription(product.getDescription());
		productEntity.setBrand(product.getBrand());
		productEntity.setDefaultPrice(product.getDefaultPrice());
		productEntity.setQuantity(product.getQuantity());
		productEntity.setSellPrice(product.getSellPrice());
		productEntity.setCreateDate(Date.valueOf(LocalDate.now()));
		productEntity.setCategory(categoryRepository.findById(product.getCategory()).orElse(null));
		productEntity.setStatus(Status.STATUS_ACTIVE);
		if(!product.getFile().isEmpty()) {
			String fileName = imageStorageService.storeFile(product.getFile());
			productEntity.setImage(fileName);
		}
		return productRepository.save(productEntity);
	}
	@Override
	public ProductEntity update(Product product) throws NotFoundException {
		ProductEntity productEntity = productRepository.findById(product.getId()).orElseThrow(() -> new NotFoundException("Không tìm thấy dữ liệu"));
		productEntity.setName(product.getName());
		productEntity.setDescription(product.getDescription());
		productEntity.setDefaultPrice(product.getDefaultPrice());
		productEntity.setSellPrice(product.getSellPrice());
		productEntity.setQuantity(product.getQuantity());
		productEntity.setUpdateDate(Date.valueOf(LocalDate.now()));
		productEntity.setCategory(categoryRepository.findById(product.getCategory()).orElse(null));
		productEntity.setStatus(State.ACTIVE.getValue());
		if(!product.getFile().isEmpty()) {
			String fileName = imageStorageService.storeFile(product.getFile());
			productEntity.setImage(fileName);
		}
		return productRepository.save(productEntity);
	
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Không tìm thấy dữ liệu"));
		productEntity.setStatus(State.DELETED.getValue());
		productRepository.save(productEntity);
	}

	@Override
	public List<ProductEntity> getProductsOnSale() {
		return productRepository.findAll();
	}

	@Override
	public List<ProductEntity> getFeaturesProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<ProductEntity> getAccessories() {
		return productRepository.findByType(1);
	}
}
