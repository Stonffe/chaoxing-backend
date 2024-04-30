package com.example.exam.controller;

import com.example.exam.entity.CourseList;
import com.example.exam.resp.ErrorCodeEnum;
import com.example.exam.resp.RestResp;
import com.example.exam.service.CourseListService;
import com.example.exam.utils.PicStore;
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

    @PostMapping("/upload")
    public RestResp<Void> handleFileUpload(@RequestParam MultipartFile file,
                                           @RequestParam String title,
                                           @RequestParam int courseId) throws Exception {
        if (title.length() == 0) return RestResp.fail("500", "未输入标题");
        String url = PicStore.savePic(file);
        CourseList courseList = new CourseList();
        courseList.setTitle(title);
        courseList.setUrl(url);
        courseList.setCourseId(courseId);
        courseListService.save(courseList);
        return RestResp.ok();
    }
}