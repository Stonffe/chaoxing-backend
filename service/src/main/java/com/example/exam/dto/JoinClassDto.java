package com.example.exam.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname: JoinClassDto
 * @Author: Stonffe
 * @Date: 2024/4/17 23:02
 */
@Data
public class JoinClassDto implements Serializable {
    private String inviteCode;
    private String phoneNum;
}
