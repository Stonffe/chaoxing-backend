package com.example.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname: LearnRecord
 * @Author: Stonffe
 * @Date: 2024/4/17 16:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("learn_record")
public class LearnRecord {
    @TableId(type = IdType.AUTO)
    private int learnRecordId;
    private int courseId;
    private int courseListId;
    /**
     * 1题，0视频
     */
    private int type;
    private String phoneNum;
    /**
     * 1完成， 0未完成
     */
    private int isOver;
}
