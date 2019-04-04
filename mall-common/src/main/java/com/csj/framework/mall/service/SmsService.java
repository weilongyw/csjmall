package com.csj.framework.mall.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.csj.framework.mall.exception.BizException;
import com.csj.framework.mall.exception.ErrorEnum;
import com.csj.framework.mall.http.HttpRequest;
import com.csj.framework.mall.utils.MD5Util;
import com.google.gson.Gson;
import lombok.Data;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 短信服务
 */
@Service
public class SmsService {

    private static final String MIAO_DI_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";

    private static final String ACCOUNT_SID = "b1aa5bb8708e489db241350df419dfeb";

    private static final String AUTH_TOEKN = "fcd0245e6dd44b28a4b25713b0ddb25c";

    private static final String RES_DATA_TYPE = "JSON";

    private static final String DELIMITER_COMMA = ",";

    private static final String CHARSET_UTF8 = "utf8";

    /**
     * 验证码短息模板
     */
    private static final String SMS_TEMPLETE_VALIDATION_CODE = "1473391083";

    private Gson gson = new Gson();

    private DozerBeanMapper mapper = new DozerBeanMapper();

    @Autowired
    private RedisTemplate redisTemplate;

    public void sendIdentifyingCode(String mobile) {
        Object object = redisTemplate.opsForValue().get(mobile);
        String cacheCode = object == null ? null : (String) object;
        if (null == cacheCode) {
            String code = String.format("%04d", new Random().nextInt(9999));
            sendCode(mobile, code);
        } else {
            Long expire = redisTemplate.getExpire(mobile);
            if (expire < 1740) {
                String code = String.format("%04d", new Random().nextInt(9999));
                sendCode(mobile, code);
            } else {
                throw new BizException("", "请务重复操作:" + (1800 - expire) + "秒后重新获取!");
            }
        }
    }

    private void sendMessage(String templeteId, String mobile, String[] params) {
        if (null == mobile) {
            throw new RuntimeException("手机号不能为空！");
        }
        SmsRequest smsRequest = new SmsRequest();
        smsRequest.setAccountSid(ACCOUNT_SID);
        smsRequest.setTo(mobile);
        smsRequest.setTemplateid(templeteId);
        smsRequest.setRespDataType(RES_DATA_TYPE);
        if (null != params && params.length > 0) {
            smsRequest.setParam(String.join(DELIMITER_COMMA, params));
        }
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        smsRequest.setTimestamp(timestamp);
        String sign = MD5Util.MD5Encode(ACCOUNT_SID + AUTH_TOEKN + timestamp, CHARSET_UTF8);
        smsRequest.setSig(sign);
        Map<String, String> paramMap = new HashMap<>();
        mapper.map(smsRequest, paramMap);
        JSONObject result = HttpRequest.post(MIAO_DI_URL, paramMap, HttpRequest.ReqType.KV);
        if (null == result) {
            throw new BizException(ErrorEnum.BIZ_SEND_SMS_FAIL);
        }
        SmsResponse smsResponse = gson.fromJson(result.toString(), SmsResponse.class);
        if (!smsResponse.getRespCode().equals("00000")) {
            throw new BizException(smsResponse.getRespCode(), smsResponse.getRespDesc());
        }
    }

    private void sendCode(String mobile, String validCode) {
        redisTemplate.opsForValue().set(mobile, validCode, 30, TimeUnit.MINUTES);
        this.sendMessage(SMS_TEMPLETE_VALIDATION_CODE, mobile, new String[]{validCode});
    }


    @Data
    public class SmsRequest {
        //必选	开发者主账号ID（ACCOUNT SID）。由32个英文字母和阿拉伯数字组成的开发者账号唯一标识符。
        private String accountSid;
        //可选	短信内容。（smsContent与templateid必须填写一项）（短信签名+短信内容。如：【秒嘀科技】您的优惠券就快过期啦！不想白白浪费，就快来使用吧！戳： m.miaodiyun.com 使用！回TD退订。）
        private String smsContent;
        //可选	短信模板ID （smsContent与templateid必须填写一项）（具体登录官网后，在模板管理查看：模板Id）
        private String templateid;
        //可选	短信变量，多个变量用英文逗号隔开（如：模板的格式为：您的订单{1}已经处理完成，货物即将发出，请于近{2}日内查收。只有templateid有内容时该参数才可填写）
        private String param;
        //必选	短信接收端手机号码集合。用英文逗号分开，每批发送的手机号数量不得超过50000个。
        private String to;
        //可选	平台分配给开发者的扩展端口号。
        private String portNumber;
        //必选	时间戳。当前系统时间（24小时制），格式"yyyyMMddHHmmss"。时间戳有效时间为5分钟。
        private String timestamp;
        //必选	签名。MD5(ACCOUNT SID + AUTH TOKEN + timestamp)。共32位（小写）。注意：MD5中的内容不包含”+”号。
        private String sig;
        //可选	响应数据类型，JSON 或 XML 格式。默认为JSON。
        private String respDataType;

    }

    @Data
    public class SmsResponse {
        //必选	请求状态码，取值00000（成功： 此步响应只表明客户的短信请求发送成功，不表明短信通道已经发送短信成功。） 具体可参照《附：返回状态码列表》
        private String respCode;
        //可选	对返回状态码的描述 如：00000 代表成功
        private String respDesc;
        //必选	表示会员营销短信发送失败的条数。
        private String failCount;
        //可选	失败列表，包含失败号码、失败原因。
        private JSONArray failList;
        //必选	短信标识符。一个由32个字符组成的短信唯一标识符。
        private String smsId;
    }


}
