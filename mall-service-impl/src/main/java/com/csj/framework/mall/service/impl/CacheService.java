package com.csj.framework.mall.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    private static String CACHE_NAME = "csj";

    @Autowired
    CacheManager cacheManager;


    String getCache(String key) {
        Cache cache = cacheManager.getCache(CACHE_NAME);
        Cache.ValueWrapper valueWrapper = cache.get(key);
        Object o = valueWrapper.get();
        if (null != o) {
            return o.toString();
        }
        return null;
    }


    /**
     * 放入缓存
     *
     * @param key
     * @param value
     * @return
     */
    void putCache(String key, String value) {
        Cache cache = cacheManager.getCache(CACHE_NAME);
        cache.put(key, value);
    }


    /**
     * 清空缓存
     *
     * @param key
     */
    void evictCache(String key) {
        Cache cache = cacheManager.getCache(CACHE_NAME);
        cache.evict(key);
    }


}
