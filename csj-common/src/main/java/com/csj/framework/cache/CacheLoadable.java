package com.csj.framework.cache;

import lombok.Data;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


@Data
public abstract class CacheLoadable<T> {

    private Class<T> entityClass;

    protected abstract T load();

    public CacheLoadable() {
        Type type = this.getClass().getGenericSuperclass();
        Type[] trueType = ((ParameterizedType) type).getActualTypeArguments();
        this.entityClass = (Class<T>) trueType[0];
    }


}
