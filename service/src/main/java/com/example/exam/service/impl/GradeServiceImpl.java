package com.example.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.vo.AnswerRecordVo;
import com.example.exam.vo.GradeVo;
import com.example.exam.vo.LearnRecordVo;
import com.example.exam.entity.Grade;
import com.example.exam.entity.User;
import com.example.exam.mapper.GradeMapper;
import com.example.exam.mapper.UserMapper;
import com.example.exam.resp.RestResp;
import com.example.exam.service.AnswerRecordService;
import com.example.exam.service.GradeService;
import com.example.exam.service.LearnRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private AnswerRecordService answerRecordService;
    @Autowired
    private LearnRecordService learnRecordService;

    /**
     * 添加成绩
     * @param phoneNum
     * @return
     */
    @Override
    public RestResp<Void> insertGrade(String phoneNum, Integer courseId) {
        if (phoneNum == null || phoneNum.length() == 0) return RestResp.fail("500", "未输入电话");
        // 更加phoneNum查询用户id
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phoneNum", phoneNum);
        User user = userMapper.selectOne(wrapper);
        // 查询正确的题
        RestResp<AnswerRecordVo> resp = answerRecordService.allStatistics(phoneNum, courseId);
        AnswerRecordVo vo = resp.getData();
        Double questionScore = 0.0;
        if (vo.getNumOfQuestion() != 0.0) {
            questionScore = vo.getRightNum() / vo.getNumOfQuestion() * 70;
        }
        // 看视频的数量
        RestResp<LearnRecordVo> resp1 = learnRecordService.videoSituation(courseId, phoneNum);
        LearnRecordVo data = resp1.getData();
        Double videoScore = 0.0;
        if (data.getNumOfCourse() != 0.0) {
            videoScore = data.getLearnedNum() / data.getNumOfCourse() * 30;
        }
        log.info("AnswerRecordVo:{}", vo);
        log.info("LearnRecordVo:{}", data);
        Double score = new Double(questionScore + videoScore);
        log.info("{}", questionScore);
        log.info("{}", videoScore);
        log.info("{}", score);
        Grade grade = new Grade();
        grade.setGrade(score);
        grade.setCourseId(courseId);
        grade.setUserId(user.getUserId());
        QueryWrapper<Grade> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", user.getUserId());
        queryWrapper.eq("courseId", courseId);
        Grade one = gradeMapper.selectOne(queryWrapper);
        if (one == null) {
            gradeMapper.insert(grade);
        } else {
            grade.setGradeId(one.getGradeId());
            gradeMapper.updateById(grade);
        }
        return RestResp.ok();
    }

    /**
     * 查询成绩
     * @param phoneNum
     * @param courseId
     * @return
     */
    @Override
    public RestResp<GradeVo> selectGrade(String phoneNum, Integer courseId) {
        if (phoneNum == null || phoneNum.length() == 0) return RestResp.fail("500", "未输入电话");
        // 查询userId
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phoneNum", phoneNum);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) return RestResp.fail("500", "电话输入错误");
        // 查询分数
        QueryWrapper<Grade> wrapper = new QueryWrapper<>();
        wrapper.eq("userId", user.getUserId())
                .eq("courseId", courseId);
        Grade grade = gradeMapper.selectOne(wrapper);
        // 查询这个课程所有人的分数
        Map<String, Object> map = new HashMap<>();
        map.put("courseId", courseId);
        List<Grade> grades = gradeMapper.selectByMap(map);
        List<Double> scores = grades.stream().map(Grade::getGrade).collect(Collectors.toList());
        // 对分数进行排序
        scores.sort((o1, o2) -> (int) (o2 - o1));
        // 找个分数对应排名
        int rank = scores.indexOf(grade.getGrade()) + 1;
        GradeVo gradeVo = new GradeVo();
        gradeVo.setGrade(grade.getGrade());
        gradeVo.setRank(rank);
        gradeVo.setPeople(grades.size());
        gradeVo.setUserId(user.getUserId());
        return RestResp.ok(gradeVo);
    }

    @Override
    public RestResp<List<GradeVo>> selectAllGrade(Integer courseId) {
        QueryWrapper<Grade> gradeQueryWrapper = new QueryWrapper<>();
        gradeQueryWrapper.eq("courseId", courseId)
                .orderByDesc("grade");
        List<Grade> grades = gradeMapper.selectList(gradeQueryWrapper);
        List<GradeVo> list = new ArrayList<>();
        int rank = 0;
        for (Grade g : grades) {
            GradeVo vo = new GradeVo();
            vo.setGrade(g.getGrade());
            vo.setRank(++rank);
            vo.setUserId(g.getUserId());
            vo.setPeople(grades.size());
            User user = userMapper.selectById(g.getUserId());
            vo.setUserName(user.getUsername());
            RestResp<AnswerRecordVo> answerRecordVo = answerRecordService.allStatistics(user.getPhoneNum(), courseId);
            vo.setAnswerRecordVo(answerRecordVo.getData());
            RestResp<LearnRecordVo> learnRecordVo = learnRecordService.videoSituation(courseId, user.getPhoneNum());
            vo.setLearnRecordVo(learnRecordVo.getData());
            list.add(vo);
        }
        return RestResp.ok(list);
    }

}