package com.ajay.hospital.controller;

import com.ajay.hospital.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class ImageController {

    private S3Service s3Service;

    @Autowired
    public ImageController(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping("/patient/image/upload")
    public String uploadPatientImage(@RequestParam("file") MultipartFile file) throws IOException {
        return s3Service.uploadFile(file);
    }

    @GetMapping("/patient/image/{fileName}")
    public String downloadPatientImage(@PathVariable("fileName") String fileName) {
        return s3Service.generatePreSignedUrl(fileName, 5);
    }
}
