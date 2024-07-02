package com.byteclub.Shawhere.controller;

import com.byteclub.Shawhere.service.FileAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/s3")
public class FileAccessController {

    @Autowired
    @Qualifier("s3")
    private FileAccessService fileAccessService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("bucketName") String bucketName) {
        String key = file.getOriginalFilename();
        try {
            fileAccessService.uploadFile(bucketName, key, file);
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully: " + key);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file: " + e.getMessage());
        }
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam("key") String key, @RequestParam("bucketName") String bucketName) {
        byte[] data = fileAccessService.downloadFile(bucketName, key);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + key + "\"")
                .body(data);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> listAllObjects(@RequestParam("bucketName") String bucketName) {
        List<String> objectKeys = fileAccessService.listAllObjects(bucketName);
        return ResponseEntity.ok(objectKeys);
    }
}
