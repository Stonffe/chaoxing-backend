package com.example.exam.vo;

import lombok.Data;

/**
 * @Classname: GradeVo
 * @Author: Stonffe
 * @Date: 2024/4/28 15:28
 */
@Data
public class GradeVo {
    private Integer userId;
    private String userName;
    private Double grade;
    private Integer rank;
    private Integer people;
    private AnswerRecordVo answerRecordVo;
    private LearnRecordVo learnRecordVo;
}
