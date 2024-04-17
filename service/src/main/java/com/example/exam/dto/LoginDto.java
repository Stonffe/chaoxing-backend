package com.example.exam.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname: loginDto
 * @Author: Stonffe
 * @Date: 2024/4/17 18:48
 */
@Data
public class LoginDto implements Serializable {
    private String phoneNum;
    private String password;
}
