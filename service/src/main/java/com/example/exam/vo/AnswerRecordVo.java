package com.example.exam.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Classname: AnswerRecordVo
 * @Author: Stonffe
 * @Date: 2024/4/27 15:52
 */
@Data
@AllArgsConstructor
public class AnswerRecordVo {
    /**
     * 确定是哪个用户
     */
    private Integer userId;
    /**
     * 正确数
     */
    private Double rightNum;
    /**
     * 问题数
     */
    private Double numOfQuestion;
}
