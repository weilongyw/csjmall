package com.csj.framework.mall.exception;

import com.csj.framework.mall.common.Constant;
import com.csj.framework.mall.common.response.BaseResponse;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class CommonAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResponse exception(MethodArgumentNotValidException e) {
        BaseResponse<String> baseResponse = new BaseResponse();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String tips = "参数不合法";
        if (errors.size() > 0) {
            tips = errors.get(0).getDefaultMessage();
        }
        baseResponse.setCode(Constant.DEFAULT_FAIL);
        baseResponse.setErrMsg(tips);
        return baseResponse;
    }

    @ExceptionHandler(UnrecognizedPropertyException.class)
    @ResponseBody
    public BaseResponse exception(UnrecognizedPropertyException e) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(Constant.DEFAULT_FAIL);
        baseResponse.setErrMsg("参数有误");
        return baseResponse;
    }


    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public BaseResponse errorHandler(BizException ex) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(ex.getErrorCode());
        baseResponse.setErrMsg(ex.getErrorMessage());
        return baseResponse;
    }


}
