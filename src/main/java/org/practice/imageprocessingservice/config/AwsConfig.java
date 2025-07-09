package org.practice.imageprocessingservice.config;


import org.practice.imageprocessingservice.AwsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;


@Configuration
@EnableConfigurationProperties(AwsProperties.class)
public class AwsConfig {

    @Bean
    public S3Client s3Client(AwsProperties awsProperities){
        AwsBasicCredentials credentials=AwsBasicCredentials.create(
                awsProperities.getS3().getAccessKey(),
                awsProperities.getS3().getSecretKey()
        );
        return S3Client.builder()
                .region(Region.of(awsProperities.getRegion()))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

    }

}
