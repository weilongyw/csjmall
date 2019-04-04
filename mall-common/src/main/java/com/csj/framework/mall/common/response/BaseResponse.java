package com.csj.framework.mall.common.response;

import com.csj.framework.mall.common.Constant;
import lombok.Data;

@Data
public class BaseResponse<T> {

    private String code;

    private String msg;

    private String errMsg;

    private T data;


    public BaseResponse<T> success(String msg, T data) {
        this.success(msg);
        this.data = data;
        return this;
    }

    public BaseResponse<T> success(String msg) {
        this.code = Constant.DEFAULT_SUCCESS;
        this.msg = msg;
        return this;
    }


    public BaseResponse<T> error(String msg, String code) {
        this.code = code;
        this.errMsg = msg;
        return this;
    }

    public BaseResponse<T> error(String msg) {
        this.error(msg, Constant.DEFAULT_FAIL);
        return this;
    }


}
