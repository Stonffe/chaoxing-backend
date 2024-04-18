package com.example.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname: Course
 * @Author: Stonffe
 * @Date: 2024/4/17 15:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("course")
public class Course {
    @TableId(type = IdType.AUTO)
    private Integer courseId;
    private String name;
    private String url;
    private String phoneNum;
    private String inviteCode;
}
