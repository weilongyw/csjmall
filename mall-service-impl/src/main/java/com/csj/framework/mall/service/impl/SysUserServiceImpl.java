package com.csj.framework.mall.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.csj.framework.mall.entity.SysUser;
import com.csj.framework.mall.mapper.SysUserMapper;
import com.csj.framework.mall.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 账号信息 服务实现类
 * </p>
 *
 * @author yewei
 * @since 2019-04-05
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public SysUser cacheUser(String id) {
        String jsonData = stringRedisTemplate.opsForValue().get(id);
        if (jsonData != null) {
            log.info("==================从redis获取数据=====================");
            return JSONObject.parseObject(jsonData, new TypeReference<SysUser>() {
            });
        }
        log.info("==================从数据库获取数据=====================");
        synchronized (this) {
            jsonData = stringRedisTemplate.opsForValue().get(id);
            if (jsonData != null) {
                log.info("==================从redis获取数据=====================");
                return JSONObject.parseObject(jsonData, new TypeReference<SysUser>() {
                });
            }
            SysUser sysUser = this.getById(id);
            if (sysUser != null) {
                stringRedisTemplate.opsForValue().set(id, JSON.toJSONString(sysUser), 1, TimeUnit.MINUTES);
            }
            return sysUser;
        }
    }
}
