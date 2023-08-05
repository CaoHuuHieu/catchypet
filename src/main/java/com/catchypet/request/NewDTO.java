package com.catchypet.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NewDTO {
	private Long id;
	private String heading;
	private String shortDescription;
	private String image;
	private String content;
	private MultipartFile file;
}
