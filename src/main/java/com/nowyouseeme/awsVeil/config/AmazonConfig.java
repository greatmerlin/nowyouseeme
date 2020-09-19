package com.nowyouseeme.awsVeil.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    @Bean
    public AmazonS3 s3() {
        AWSCredentials credentials = new BasicAWSCredentials(
                "AKIAIOBBYSSSZZZKTAXA",
                "mNOIPZXI43EKsug8NH9eB/5ZNCzNZjiws0fAVTRK");

        AmazonS3 amazonS3 = AmazonS3Client.builder()
                .withRegion("us-west-1")
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        return amazonS3;
    }
}
