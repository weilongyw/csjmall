package com.csj.framework.mall.controller;


import com.csj.framework.common.response.BaseResponse;
import com.csj.framework.mall.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 短信
 */
@Controller
@RequestMapping("api/sms")
public class SmsController {

    @Autowired
    SmsService smsService;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 发送短信验证码
     *
     * @return
     */
    @GetMapping("identifyingcode")
    @ResponseBody
    public BaseResponse sendIdentifyingCode(@RequestParam("mobile") String mobile) {
        BaseResponse response = new BaseResponse<>();
        smsService.sendIdentifyingCode(mobile);
        response.success("短信已发送");
        return response;
    }



}
