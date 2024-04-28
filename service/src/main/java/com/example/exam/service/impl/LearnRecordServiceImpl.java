package com.example.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.dto.LearnRecordDto;
import com.example.exam.entity.SelectedCourses;
import com.example.exam.entity.User;
import com.example.exam.mapper.SelectedCoursesMapper;
import com.example.exam.mapper.UserMapper;
import com.example.exam.vo.LearnRecordVo;
import com.example.exam.entity.Course;
import com.example.exam.entity.LearnRecord;
import com.example.exam.mapper.CourseMapper;
import com.example.exam.mapper.LearnRecordMapper;
import com.example.exam.resp.RestResp;
import com.example.exam.service.LearnRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname: LearnRecordServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/17 23:57
 */
@Service
public class LearnRecordServiceImpl extends ServiceImpl<LearnRecordMapper, LearnRecord> implements LearnRecordService {
    @Autowired
    private LearnRecordMapper learnRecordMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SelectedCoursesMapper selectedCoursesMapper;

    /**
     * 查询学习记录
     *
     * @param learnRecordDto
     * @return
     */
    @Override
    public RestResp<List<LearnRecord>> getLearnRecord(LearnRecordDto learnRecordDto) {
        QueryWrapper<LearnRecord> wrapper = new QueryWrapper<>();
        wrapper.eq("phoneNum", learnRecordDto.getPhoneNum());
        wrapper.eq("type", learnRecordDto.getType());
        wrapper.eq("courseId", learnRecordDto.getCourseId());
        List<LearnRecord> list = learnRecordMapper.selectList(wrapper);
        return RestResp.ok(list);
    }

    /**
     * 查询一个学生的学习情况
     *
     * @param courseId
     * @param phoneNum
     * @return
     */
    @Override
    public RestResp<LearnRecordVo> learnSituation(Integer courseId, String phoneNum) {
        return RestResp.ok(selectOneSituation(courseId, phoneNum));
    }

    private LearnRecordVo selectOneSituation(Integer courseId, String phoneNum) {
        // 根据课程id查询有多少个课时
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.eq("courseId", courseId);
        Integer numOfCourse = courseMapper.selectCount(courseQueryWrapper);
        // 从学习记录表里面查询用户有多少个学习记录
        QueryWrapper<LearnRecord> wrapper = new QueryWrapper<>();
        wrapper.eq("courseId", courseId)
                .eq("phoneNum", phoneNum);
        Integer learnedNum = learnRecordMapper.selectCount(wrapper);
        // 查询用户id
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phoneNum", phoneNum);
        User user = userMapper.selectOne(userQueryWrapper);
        // 封装成vo对象返回
        LearnRecordVo learnRecordVo = new LearnRecordVo(user.getUserId(), Double.valueOf(learnedNum), Double.valueOf(numOfCourse));
        return learnRecordVo;
    }

    /**
     * 查询整个课程学生完成情况
     *
     * @param courseId
     * @return
     */
    @Override
    public RestResp<List<LearnRecordVo>> allLearnSituation(Integer courseId) {
        // 首先查询所有选择整个课程的用户phoneNum
        QueryWrapper<SelectedCourses> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("courseId", courseId);
        List<SelectedCourses> list1 = selectedCoursesMapper.selectList(wrapper1);
        List<String> phoneNums = list1.stream().map(SelectedCourses::getPhoneNum)
                .collect(Collectors.toList());
        ArrayList<LearnRecordVo> learnRecords = new ArrayList<>();
        // 复用上面查询单个用户学习情况的代码 封装成一个List
        for (String phoneNum : phoneNums) {
            learnRecords.add(selectOneSituation(courseId, phoneNum));
        }
        return RestResp.ok(learnRecords);
    }

    /**
     * 添加学习记录
     *
     * @param learnRecord
     * @return
     */
    @Override
    public RestResp<Void> addLearnRecord(LearnRecord learnRecord) {
        QueryWrapper<LearnRecord> wrapper = new QueryWrapper<>();
        wrapper.eq("phoneNum", learnRecord.getPhoneNum());
        wrapper.eq("type", learnRecord.getType());
        wrapper.eq("courseListId", learnRecord.getCourseListId());
        wrapper.eq("courseId", learnRecord.getCourseId());
        LearnRecord one = learnRecordMapper.selectOne(wrapper);
        if (one == null) learnRecordMapper.insert(learnRecord);
        return RestResp.ok();
    }

    /**
     * 查询视频观看数量情况
     *
     * @param courseId
     * @param phoneNum
     * @return
     */
    @Override
    public RestResp<LearnRecordVo> videoSituation(Integer courseId, String phoneNum) {
        // 根据课程id查询有多少个课时
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.eq("courseId", courseId);
        Integer numOfCourse = courseMapper.selectCount(courseQueryWrapper);
        // 从学习记录表里面查询用户有多少个学习记录
        QueryWrapper<LearnRecord> wrapper = new QueryWrapper<>();
        wrapper.eq("courseId", courseId)
                .eq("phoneNum", phoneNum)
                // type 0 为视频
                .eq("type", 0);
        Integer learnedNum = learnRecordMapper.selectCount(wrapper);
        // 查询用户id
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phoneNum", phoneNum);
        User user = userMapper.selectOne(userQueryWrapper);
        // 封装成vo对象返回
        LearnRecordVo learnRecordVo = new LearnRecordVo(user.getUserId(), Double.valueOf(learnedNum), Double.valueOf(numOfCourse));
        return RestResp.ok(learnRecordVo);
    }
}
