package org.practice.imageprocessingservice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "aws")
public class AwsProperties{
    private String region;
    private S3 s3;
    @Setter
    @Getter
    public static class S3{
        private String bucketName;
        private String accessKey;
        private String secretKey;

        public S3() {
        }
    }

    public AwsProperties() {

    }

}

