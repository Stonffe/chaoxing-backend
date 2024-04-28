package com.example.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.dto.AnswerQuestionDto;
import com.example.exam.entity.AnswerRecord;
import com.example.exam.entity.Question;
import com.example.exam.entity.SelectedCourses;
import com.example.exam.entity.User;
import com.example.exam.mapper.AnswerRecordMapper;
import com.example.exam.mapper.QuestionMapper;
import com.example.exam.mapper.SelectedCoursesMapper;
import com.example.exam.mapper.UserMapper;
import com.example.exam.resp.RestResp;
import com.example.exam.service.AnswerRecordService;
import com.example.exam.vo.AnswerRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname: AnswerRecordServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/25 14:55
 */
@Service
public class AnswerRecordServiceImpl extends ServiceImpl<AnswerRecordMapper, AnswerRecord> implements AnswerRecordService {
    @Autowired
    private AnswerRecordMapper answerRecordMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private SelectedCoursesMapper selectedCoursesMapper;

    /**
     * 记录答题情况
     *
     * @param dto
     * @return
     */
    @Override
    public RestResp<Void> logAnswer(AnswerQuestionDto dto) {
        if (isCompleted(dto.getPhoneNum(), dto.getQuestionId()).getData() == 1) return null;
        // 查出phoneNum对应UserId
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phoneNum", dto.getPhoneNum());
        User user = userMapper.selectOne(userQueryWrapper);
        Question question = questionMapper.selectById(dto.getQuestionId());
        char answer = question.getAnswer();
        // 判断答案是否正确
        Integer isTrue = answer == dto.getAnswer() ? 1 : 0;
        AnswerRecord answerRecord = new AnswerRecord();
        answerRecord.setUserId(user.getUserId());
        answerRecord.setQuestionId(dto.getQuestionId());
        answerRecord.setAnswer(dto.getAnswer());
        answerRecord.setIsTrue(isTrue);
        answerRecordMapper.insert(answerRecord);
        return RestResp.ok();
    }

    /**
     * 查询答题情况
     *
     * @param phoneNum
     * @param courseListId
     * @return
     */
    @Override
    public RestResp<List<AnswerRecord>> selectAnswerRecord(String phoneNum, int courseListId) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phoneNum", phoneNum);
        User user = userMapper.selectOne(userQueryWrapper);
        QueryWrapper<Question> questionQueryWrapper = new QueryWrapper<>();
        questionQueryWrapper.eq("courseListId", courseListId);
        List<Question> questions = questionMapper.selectList(questionQueryWrapper);
        ArrayList<AnswerRecord> list = new ArrayList<>();
        for (Question q : questions) {
            QueryWrapper<AnswerRecord> answerRecordQueryWrapper = new QueryWrapper<>();
            answerRecordQueryWrapper.eq("userId", user.getUserId())
                    .eq("questionId", q.getQuestionId());
            AnswerRecord answerRecord = answerRecordMapper.selectOne(answerRecordQueryWrapper);
            list.add(answerRecord);
        }
        return RestResp.ok(list);
    }

    /**
     * 判断题目是否完成
     *
     * @param phoneNum
     * @param questionId
     * @return
     */
    @Override
    public RestResp<Integer> isCompleted(String phoneNum, int questionId) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phoneNum", phoneNum);
        User user = userMapper.selectOne(userQueryWrapper);
        QueryWrapper<AnswerRecord> answerRecordQueryWrapper = new QueryWrapper<>();
        answerRecordQueryWrapper.eq("questionId", questionId)
                .eq("userId", user.getUserId());
        return RestResp.ok(answerRecordMapper.selectCount(answerRecordQueryWrapper));
    }

    /**
     * 用户一个课时的答题正确数量统计
     *
     * @param phoneNum
     * @param courseListId
     * @return
     */
    @Override
    public RestResp<AnswerRecordVo> sectionStatistics(String phoneNum, Integer courseListId) {
        QueryWrapper<Question> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("courseListId", courseListId);
        // QuestionList
        List<Question> list1 = questionMapper.selectList(wrapper1);
        // QuestionIdList
        List<Integer> list2 = list1.stream().map(Question::getQuestionId).collect(Collectors.toList());
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("phoneNum", phoneNum);
        User user = userMapper.selectOne(wrapper2);
        Integer rightNum = 0;
        for (Integer i : list2) {
            QueryWrapper<AnswerRecord> wrapper3 = new QueryWrapper<>();
            // 一条一条查询正确的答题记录
            wrapper3.eq("userId", user.getUserId())
                    .eq("questionId", i)
                    .eq("isTrue", 1);
            // 加和
            rightNum += answerRecordMapper.selectCount(wrapper3);
        }
        AnswerRecordVo answerRecordVo = new AnswerRecordVo(user.getUserId(), Double.valueOf(rightNum), Double.valueOf(list1.size()));
        return RestResp.ok(answerRecordVo);
    }

    /**
     * 用户一个课程的答题正确数量统计
     *
     * @param phoneNum
     * @param courseId
     * @return
     */
    @Override
    public RestResp<AnswerRecordVo> allStatistics(String phoneNum, Integer courseId) {
        QueryWrapper<Question> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("courseId", courseId);
        // QuestionList
        List<Question> list1 = questionMapper.selectList(wrapper1);
        // QuestionIdList
        List<Integer> list2 = list1.stream().map(Question::getQuestionId).collect(Collectors.toList());
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("phoneNum", phoneNum);
        User user = userMapper.selectOne(wrapper2);
        Integer rightNum = 0;
        for (Integer i : list2) {
            QueryWrapper<AnswerRecord> wrapper3 = new QueryWrapper<>();
            // 一条一条查询正确的答题记录
            wrapper3.eq("userId", user.getUserId())
                    .eq("questionId", i)
                    .eq("isTrue", 1);
            // 加和
            rightNum += answerRecordMapper.selectCount(wrapper3);
        }
        AnswerRecordVo answerRecordVo = new AnswerRecordVo(user.getUserId(), Double.valueOf(rightNum), Double.valueOf(list1.size()));
        return RestResp.ok(answerRecordVo);
    }

    /**
     * 一个课程所用用户的答题正确数量统计
     *
     * @param courseId
     * @return
     */
    @Override
    public RestResp<List<AnswerRecordVo>> allUserStatistics(Integer courseId) {
        QueryWrapper<SelectedCourses> wrapper = new QueryWrapper<>();
        wrapper.eq("courseId", courseId);
        // SelectedCoursesList
        List<SelectedCourses> list0 = selectedCoursesMapper.selectList(wrapper);
        // phoneNumList 所有用户的电话号码
        List<String> list = list0.stream().map(SelectedCourses::getPhoneNum).collect(Collectors.toList());
        List<AnswerRecordVo> res = new ArrayList<>();
        for (String phoneNum : list) {
            QueryWrapper<Question> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("courseId", courseId);
            // QuestionList
            List<Question> list1 = questionMapper.selectList(wrapper1);
            // QuestionIdList
            List<Integer> list2 = list1.stream().map(Question::getQuestionId).collect(Collectors.toList());
            QueryWrapper<User> wrapper2 = new QueryWrapper<>();
            wrapper2.eq("phoneNum", phoneNum);
            User user = userMapper.selectOne(wrapper2);
            Integer rightNum = 0;
            for (Integer i : list2) {
                QueryWrapper<AnswerRecord> wrapper3 = new QueryWrapper<>();
                // 一条一条查询正确的答题记录
                wrapper3.eq("userId", user.getUserId())
                        .eq("questionId", i)
                        .eq("isTrue", 1);
                // 加和
                rightNum += answerRecordMapper.selectCount(wrapper3);
            }
            AnswerRecordVo answerRecordVo = new AnswerRecordVo(user.getUserId(), Double.valueOf(rightNum), Double.valueOf(list1.size()));
            res.add(answerRecordVo);
        }
        return RestResp.ok(res);
    }

}
