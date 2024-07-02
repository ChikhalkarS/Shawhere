package com.byteclub.Shawhere.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileAccessService {
    void uploadFile(String bucketName, String key, MultipartFile file) throws IOException;
    byte[] downloadFile(String bucketName, String key);
    List<String> listAllObjects(String bucketName);
}
