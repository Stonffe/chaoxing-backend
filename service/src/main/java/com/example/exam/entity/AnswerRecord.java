package com.example.exam.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname: AnswerRecord
 * @Author: Stonffe
 * @Date: 2024/4/17 16:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("answer_record")
public class AnswerRecord {
    private int answerRecordId;
    private int userId;
    private int questionId;
    private char answer;
    /**
     * 0err 1true
     */
    private int isTrue;
}
