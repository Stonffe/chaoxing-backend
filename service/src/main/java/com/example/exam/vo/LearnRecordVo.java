package com.example.exam.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Classname: LearnRecordVo
 * @Author: Stonffe
 * @Date: 2024/4/27 14:14
 */
@Data
@AllArgsConstructor
public class LearnRecordVo {
    /**
     * 确定是哪个用户
     */
    private Integer userId;
    /**
     * 以学习数
     */
    private Double learnedNum;
    /**
     * 课程数
     */
    private Double numOfCourse;
}
