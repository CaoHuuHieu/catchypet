package com.catchypet.service;


import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
    public String storeFile(MultipartFile file);
}
