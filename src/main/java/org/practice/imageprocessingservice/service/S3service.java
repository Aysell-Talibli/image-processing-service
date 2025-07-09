package org.practice.imageprocessingservice.service;

import lombok.RequiredArgsConstructor;
import org.practice.imageprocessingservice.AwsProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class S3service {

    private final AwsProperties awsProperties;
    private final S3Client s3Client;

    public String uploadFile(String fileName, MultipartFile multipartFile){
        try{
             PutObjectRequest putObjectRequest= PutObjectRequest.builder()
                     .bucket(awsProperties.getS3().getBucketName())
                     .key(fileName)
                     .contentType(multipartFile.getContentType())
                     .build();
             s3Client.putObject(putObjectRequest, RequestBody.fromBytes(multipartFile.getBytes()));
             return "https://"+awsProperties.getS3().getBucketName()+".s3.amazonaws.com/"+fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file ",e);
        }
    }

}
