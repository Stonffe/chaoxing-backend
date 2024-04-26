package com.example.exam.controller;

import com.example.exam.entity.CourseList;
import com.example.exam.resp.ErrorCodeEnum;
import com.example.exam.resp.RestResp;
import com.example.exam.service.CourseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
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
    private String base = "http://localhost:8090/receive/";
    @Autowired
    private CourseListService courseListService;

    @PostMapping("/upload/{title}/{courseId}")
    public RestResp<Void> handleFileUpload(@RequestParam("file") MultipartFile file,
                                           @PathVariable String title,
                                           @PathVariable int courseId) {
        if (file.isEmpty()) {
            return RestResp.fail(ErrorCodeEnum.FILE_NOT_EXISTS);
        }
        try {
            String fileName = file.getOriginalFilename();
            String url = base + fileName;
            File destFile = new File(uploadDir + File.separator + fileName);
            file.transferTo(destFile);
            CourseList courseList = new CourseList();
            courseList.setTitle(title);
            courseList.setUrl(url);
            courseList.setCourseId(courseId);
            courseListService.save(courseList);
            return RestResp.ok();
        } catch (IOException e) {
            e.printStackTrace();
            return RestResp.fail(ErrorCodeEnum.FILE_NOT_EXISTS);
        }
    }
}