package com.csj.framework.exception;

public enum ErrorEnum implements IErrorCode {
    SYSTEM_ERROR("9999", "系统错误"),
    LOGIN_EXPIRED("302", "登录超时,请重新登录"),

    EXPIRED_IDENTIFYING_CODE("1002", "验证码错误"),
    EXPIRED_TOKEN("1003", "登录已过期"),

    NOT_EXSITS_USER("1101", "用户不存在"),
    NOT_EXSITS_PRODUCT("1102", "商品不存在"),
    NOT_EXSITS_RECORD("1103", "记录不存在"),

    NOT_BLANK_PRODUCT_NO("1201", "商品编号不能为空"),
    NOT_BLANK_PRODUCT_NUM("1203", "商品数量编号不能为空"),

    ERROR_REQUEST_TYPE("1305", "请求类型有误"),
    ERROR_FILE_TTPE("1306", "文件类型有误"),
    ERROR_FILE_MODULE("1308", "请检查文件模板"),
    ERROR_NET_WORK("1310", "网络异常"),

    BIZ_ERROR_USERNAME_PASSWORD("1401", "用户名密码有误"),
    BIZ_ERROR_ORIGIN_PWD("1402", "原密码有误"),
    BIZ_ITEM_NUM_NOT_BE_ZERO("1403", "明细数量不能为0"),
    BIZ_FILL_INFO_FIRST("1404", "请先完善企业信息"),
    BIZ_ENT_CHECKING("1405", "企业资质审核中"),
    BIZ_SEND_SMS_FAIL("1406", "短信发送失败"),
    BIZ_LOGIN_TYPE_ERROR("1407", "登录类型有误"),
    BIZ_EXSITS_ACCOUNT("1408", "账号已存在"),
    BIZ_EXSITS_MOBILE("1409", "手机号已存在"),
    BIZ_SEARCH_FAIL("1410", "查询失败");

    private String errorCode;

    private String errorMessage;

    ErrorEnum(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
