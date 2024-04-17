package com.example.exam.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname: Question
 * @Author: Stonffe
 * @Date: 2024/4/17 16:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("question")
public class Question {
    private int questionId;
    private String title;
    private int courseListId;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private char answer;
    private int right;
    private int error;
    /**
     * 判断选择还是判断 int类型 1 选择 0判断
     */
    private int kind;
}
