package com.example.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exam.dto.JoinClassDto;
import com.example.exam.entity.Course;
import com.example.exam.entity.SelectedCourses;
import com.example.exam.entity.User;
import com.example.exam.resp.RestResp;

import java.util.List;

/**
 * @Classname: SelectedCoursesService
 * @Description:
 * @Author: Stonffe
 * @Date: 2024/4/18 16:10
 */
public interface SelectedCoursesService extends IService<SelectedCourses> {
    /**
     * 查询已选课程列表
     *
     * @param phoneNum
     * @return
     */
    RestResp<List<Course>> getJoinClass(String phoneNum);

    /**
     * 使用邀请码加入课程
     *
     * @param joinClassDto
     * @return
     */
    RestResp<Void> joinClass(JoinClassDto joinClassDto);

    /**
     * 根据课程id查询选课学生
     *
     * @param courseId
     * @return
     */
    RestResp<List<User>> getUserByCourseId(Integer courseId);
}
