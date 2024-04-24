package com.example.exam.dto;

import lombok.Data;


/**
 * @Classname: ResultDto
 * @Author: Stonffe
 * @Date: 2024/4/19 22:07
 */
@Data
public class ResultDto {
    private Integer questionId;
    /**
     * 0err 1true
     */
    private int isTrue;
}
