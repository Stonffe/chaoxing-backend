package com.example.exam.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname: RegisterDto
 * @Author: Stonffe
 * @Date: 2024/4/17 21:31
 */
@Data
public class RegisterDto implements Serializable {
    private String phoneNum;
    private String username;
    private String password;
}
