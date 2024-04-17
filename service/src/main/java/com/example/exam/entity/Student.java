package com.example.exam.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname: Student
 * @Author: Stonffe
 * @Date: 2024/4/16 14:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("student")
public class Student {
    private int studentId;
    private String name;
    private String password;
    private int role;
}
