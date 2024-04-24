package com.example.exam.controller;

import com.example.exam.resp.ErrorCodeEnum;
import com.example.exam.resp.RestResp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Classname: StreamController
 * @Author: Stonffe
 * @Date: 2024/4/19 14:51
 */
@RestController
public class FileUploadController {

    @Value("${upload.dir}")
    private String uploadDir;

    @PostMapping("/upload")
    public RestResp<Void> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return RestResp.fail(ErrorCodeEnum.FILE_NOT_EXISTS);
        }

        try {
            String fileName = file.getOriginalFilename();
            File destFile = new File(uploadDir + File.separator + fileName);
            file.transferTo(destFile);
            return RestResp.ok();
        } catch (IOException e) {
            e.printStackTrace();
            return RestResp.fail(ErrorCodeEnum.FILE_NOT_EXISTS);
        }
    }
}