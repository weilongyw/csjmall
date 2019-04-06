package com.csj.framework.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.csj.framework.mall.entity.SysUser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class StringCacheTemplete {

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    private final static int defaultExpire = 1000;

    private final static int defaultBlankExpire = 5;


    public <T> T getCacheData(String key, CacheLoadable<T> cacheLoadable) {
        return this.getCacheData(key, Long.valueOf(new Random().nextInt(defaultExpire)), TimeUnit.SECONDS, cacheLoadable);
    }


    public <T> T getCacheData(String key, long expire, TimeUnit timeUnit, CacheLoadable<T> cacheLoadable) {

        cacheLoadable.getEntityClass().getGenericSuperclass();
        String jsonData = stringRedisTemplate.opsForValue().get(key);
        if (jsonData != null) {
            log.info("========================从redis获取数据=============================");
            return JSONObject.parseObject(jsonData, cacheLoadable.getEntityClass());
        }
        synchronized (this) {
            jsonData = stringRedisTemplate.opsForValue().get(key);
            if (jsonData != null) {
                log.info("========================从redis获取数据=============================");
                return JSONObject.parseObject(jsonData, cacheLoadable.getEntityClass());
            }
            log.info("========================从数据库获取数据=============================");
            T result = cacheLoadable.load();
            if (null != result) {
                stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(result), expire, timeUnit);
            } else {
                stringRedisTemplate.opsForValue().set(key, "", Long.valueOf(defaultBlankExpire), TimeUnit.SECONDS);
            }
            return result;
        }
    }

}
