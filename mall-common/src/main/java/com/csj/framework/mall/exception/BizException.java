package com.csj.framework.mall.exception;

import lombok.Data;

@Data
public class BizException extends RuntimeException {

    private IErrorCode iErrorCode;

    private String errorCode;

    private String errorMessage;

    public BizException(IErrorCode iErrorCode) {
        super();
        this.iErrorCode = iErrorCode;
        this.errorCode = iErrorCode.getErrorCode();
        this.errorMessage = iErrorCode.getErrorMessage();
    }

    public BizException(String code, String errorMessage) {
        IErrorCode iErrorCode = new IErrorCode() {
            @Override
            public String getErrorCode() {
                return code;
            }

            @Override
            public String getErrorMessage() {
                return errorMessage;
            }
        };
        this.iErrorCode = iErrorCode;
        this.errorCode = iErrorCode.getErrorCode();
        this.errorMessage = iErrorCode.getErrorMessage();
    }

}
