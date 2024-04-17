package com.example.exam.entity;

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
@TableName("Course")
public class Course {
    private int courseId;
    private String name;
    private String url;
    private String phoneNum;
    //1创建者， 0学生
    private int role;
}
