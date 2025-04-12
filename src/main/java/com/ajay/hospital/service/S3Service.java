package com.ajay.hospital.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

@Service
public class S3Service {
    private final AmazonS3 amazonS3;
    private final String bucketName;

    public S3Service(AmazonS3 amazonS3, @Value("${aws.s3.bucket.name}") String bucketName) {
        this.amazonS3 = amazonS3;
        this.bucketName = bucketName;
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();

        InputStream inputStream = file.getInputStream();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());
        amazonS3.putObject(bucketName, fileName, inputStream, metadata);

        return amazonS3.getUrl(bucketName, fileName).toString();
    }

    public InputStream downloadFile(String fileName) {
        S3Object s3Object = amazonS3.getObject(new GetObjectRequest(bucketName, fileName));
        return  s3Object.getObjectContent();
    }

    public String generatePreSignedUrl(String fileName, int expirationTimeInMinutes) {
        GeneratePresignedUrlRequest presignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, fileName)
                        .withMethod(HttpMethod.GET)
                        .withExpiration(new Date(System.currentTimeMillis() + (long) expirationTimeInMinutes * 1000 * 60));
        return amazonS3.generatePresignedUrl(presignedUrlRequest).toString();
    }
}
