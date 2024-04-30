package com.example.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.dto.JoinClassDto;
import com.example.exam.entity.Course;
import com.example.exam.entity.SelectedCourses;
import com.example.exam.entity.User;
import com.example.exam.mapper.CourseMapper;
import com.example.exam.mapper.SelectedCoursesMapper;
import com.example.exam.mapper.UserMapper;
import com.example.exam.resp.RestResp;
import com.example.exam.service.SelectedCoursesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname: SelectedCoursesServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/18 16:11
 */
@Service
@Slf4j
public class SelectedCoursesServiceImpl extends ServiceImpl<SelectedCoursesMapper, SelectedCourses> implements SelectedCoursesService {
    @Autowired
    private SelectedCoursesMapper mapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private UserMapper userMapper;


    /**
     * 查询已选课程列表
     *
     * @param phoneNum
     * @return
     */
    @Override
    public RestResp<List<Course>> getJoinClass(String phoneNum) {
        QueryWrapper<SelectedCourses> wrapper = new QueryWrapper<>();
        wrapper.eq("phoneNum", phoneNum);
        // 根据手机号查询已选课程
        List<SelectedCourses> list = mapper.selectList(wrapper);
        // 没选课程
        if (list.size() == 0) return RestResp.ok(new ArrayList<>());
        List<Integer> courseIdList = new ArrayList<>();
        for (SelectedCourses s : list) {
            // 把已选课程的id封装成一个List
            courseIdList.add(s.getCourseId());
        }
        // 批量查询整个List
        List<Course> courses = courseMapper.selectBatchIds(courseIdList);
        return RestResp.ok(courses);
    }

    /**
     * 使用邀请码加入课程
     *
     * @param joinClassDto
     * @return
     */
    @Override
    public RestResp<Void> joinClass(JoinClassDto joinClassDto) {
        if (joinClassDto.getInviteCode() == null || joinClassDto.getInviteCode().length() == 0) {
            return RestResp.fail("500", "邀请码为空");
        }
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("inviteCode", joinClassDto.getInviteCode());
        // 通过邀请码查询课程id
        Course course = courseMapper.selectOne(wrapper);
        if (course == null) {
            return RestResp.fail("500", "请检查邀请码是否错误");
        }
        int courseId = course.getCourseId();
        // 将用户的信息插入到已选课程表中
        SelectedCourses courses = new SelectedCourses();
        courses.setCourseId(courseId);
        courses.setPhoneNum(joinClassDto.getPhoneNum());
        mapper.insert(courses);
        return RestResp.ok();
    }
    /**
     * 根据课程id查询选课学生
     * @param courseId
     * @return
     */
    @Override
    public RestResp<List<User>> getUserByCourseId(Integer courseId) {
        // 先根据课程id查询选课表里面的所有phoneNum
        if (courseId == null) return RestResp.fail("500", "课程id未输入");
        QueryWrapper<SelectedCourses> wrapper = new QueryWrapper<>();
        wrapper.eq("courseId", courseId);
        List<SelectedCourses> selectedCourses = mapper.selectList(wrapper);
        // 没人选课
        if (selectedCourses.size() == 0) return RestResp.ok(new ArrayList<>());
        List<String> phoneNumList = selectedCourses.stream()
                .map(SelectedCourses::getPhoneNum).collect(Collectors.toList());
        // 再根据phoneNum从user表里面查询user
        List<User> users = new ArrayList<>();
        for (String phoneNum : phoneNumList) {
            QueryWrapper<User> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("phoneNum", phoneNum);
            users.add(userMapper.selectOne(wrapper1));
        }
        return RestResp.ok(users);
    }

}
