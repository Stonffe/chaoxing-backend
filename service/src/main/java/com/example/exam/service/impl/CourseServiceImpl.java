package com.example.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.dto.JoinClassDto;
import com.example.exam.entity.Course;
import com.example.exam.mapper.CourseMapper;
import com.example.exam.resp.RestResp;
import com.example.exam.service.CourseService;
import com.example.exam.utils.PicStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Classname: CourseServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/17 22:34
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    /**
     * 查询课程列表
     *
     * @param phoneNum
     * @return
     */
    @Override
    public RestResp<List<Course>> getCreateClass(String phoneNum) {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("phoneNum", phoneNum);
        List<Course> list = courseMapper.selectList(wrapper);
        return RestResp.ok(list);
    }

    /**
     * 创建课程
     *
     * @param name
     * @param phoneNum
     * @param inviteCode
     * @param file
     * @return
     */
    @Override
    public RestResp<Void> createCourse(String name, String phoneNum, String inviteCode, MultipartFile file) {
        Course course = new Course();
        try {
            String url = PicStore.savePic(file);
            course.setName(name);
            course.setPhoneNum(phoneNum);
            course.setUrl(url);
            course.setInviteCode(inviteCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        courseMapper.insert(course);
        return RestResp.ok();
    }
}
