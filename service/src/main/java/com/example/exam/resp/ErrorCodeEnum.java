package com.example.exam.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    /**
     * 正确执行后的返回
     */
    OK("200", "success"),
    /**
     * 用户不存在
     */
    USER_NOT_EXIST("500", "用户不存在"),
    /**
     * 密码错误
     */
    PASSWORD_ERROR("501", "密码错误"),
    /**
     * 用户已存在
     */
    USER_EXISTS("502", "用户已存在"),
    /**
     * 文件不存在
     */
    FILE_NOT_EXISTS("503", "文件不存在");
    /**
     * 错误码
     */
    private final String code;

    /**
     * 中文描述
     */
    private final String message;
}
