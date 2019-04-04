package com.csj.framework.mall.dto.user;

import lombok.Data;

@Data
public class UserLoginDTO {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passwd;
    /**
     * 登录类型
     */
    private String loginType;
    /**
     * 验证码
     */
    private String identifyingCode;

}
