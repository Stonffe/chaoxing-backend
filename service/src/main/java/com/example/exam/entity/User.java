package com.example.exam.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname: Teacher
 * @Author: Stonffe
 * @Date: 2024/4/16 14:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    private int userId ;
    private String username;
    private String password;
    private String phoneNum;
}
