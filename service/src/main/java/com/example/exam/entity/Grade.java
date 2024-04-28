package com.example.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname: Grade
 * @Author: Stonffe
 * @Date: 2024/4/27 23:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("grade")
public class Grade {
    @TableId(type = IdType.AUTO)
    private Integer gradeId;
    private Integer userId;
    private Integer courseId;
    private Double grade;
}
