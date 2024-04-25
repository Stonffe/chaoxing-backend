package com.example.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exam.dto.JoinClassDto;
import com.example.exam.entity.Course;
import com.example.exam.resp.RestResp;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Classname: CourseService
 * @Description:
 * @Author: Stonffe
 * @Date: 2024/4/17 22:32
 */
public interface CourseService extends IService<Course> {

    /**
     * 查询课程列表
     *
     * @param phoneNum
     * @return
     */
    RestResp<List<Course>> getCreateClass(String phoneNum);

    /**
     * 创建课程
     *
     * @param name
     * @param phoneNum
     * @param inviteCode
     * @param file
     * @return
     */
    RestResp<Void> createCourse(String name, String phoneNum,
                                String inviteCode, MultipartFile file);
}
