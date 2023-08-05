package com.catchypet.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class Product {
	private Long id;
	private String name;
	private String description;
	private String brand;
	private Integer defaultPrice;
	private Integer sellPrice;
	private Long category;
	private Integer status;
	private MultipartFile file;
	private String images;
	private Integer type;
	private Integer quantity;

}
