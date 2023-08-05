package com.catchypet.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class Category {
	private Long id;
	private String name;
	private String description;
	private Integer type;
	private String fileName;
	private Integer status;
	private MultipartFile file;

}
