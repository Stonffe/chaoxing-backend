package com.example.exam.dto;

import lombok.Data;

/**
 * @Classname: AnswerQuetionDto
 * @Author: Stonffe
 * @Date: 2024/4/19 21:46
 */
@Data
public class AnswerQuestionDto {
    private String phoneNum;
    private Integer questionId;
    private Character answer;
}
