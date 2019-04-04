package com.csj.framework.mall.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserRegisterDTO {

    @NotBlank(message = "用户名不能为空")
    @Size(max = 16, min = 8, message = "用户名长度在 {min}-{max}之间")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String passwd;
    @NotBlank(message = "手机号不能为空")
    private String phone;
    @NotBlank(message = "验证码不能为空")
    private String identifyingCode;


}
