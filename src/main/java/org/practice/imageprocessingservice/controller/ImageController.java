package org.practice.imageprocessingservice.controller;

import lombok.RequiredArgsConstructor;
import org.practice.imageprocessingservice.service.S3service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {

    private final S3service s3service;
    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("multipart") MultipartFile multipartFile){
        String url=s3service.uploadFile("original/"+multipartFile.getOriginalFilename(),multipartFile);
        return ResponseEntity.ok(url);

    }
}
