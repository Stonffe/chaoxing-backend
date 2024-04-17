package com.example.exam.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.Objects;

/**
 * @Classname: RestResp
 * @Author: Stonffe
 * @Date: 2024/4/17 18:32
 */
@Getter
public class RestResp<T> {

    /**
     * 响应码
     */
    @Schema(description = "错误码，200-没有错误")
    private String code;

    /**
     * 响应消息
     */
    @Schema(description = "响应消息")
    private String message;

    /**
     * 响应数据
     */
    @Schema(description = "响应数据")
    private T data;

    private RestResp() {
        this.code = ErrorCodeEnum.OK.getCode();
        this.message = ErrorCodeEnum.OK.getMessage();
    }

    private RestResp(ErrorCodeEnum errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    private RestResp(T data) {
        this();
        this.data = data;
    }

    /**
     * 业务处理成功,无数据返回
     */
    public static RestResp<Void> ok() {
        return new RestResp<>();
    }

    /**
     * 业务处理成功，有数据返回
     */
    public static <T> RestResp<T> ok(T data) {
        return new RestResp<>(data);
    }

    /**
     * 业务处理失败
     */
    public static RestResp<Void> fail(ErrorCodeEnum errorCode) {
        return new RestResp<>(errorCode);
    }


    /**
     * 判断是否成功
     */
    public boolean isOk() {
        return Objects.equals(this.code, ErrorCodeEnum.OK.getCode());
    }

}
