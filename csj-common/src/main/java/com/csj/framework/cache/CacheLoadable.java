package com.csj.framework.cache;

import lombok.Data;

import java.lang.reflect.Type;


@Data
public abstract class CacheLoadable<T> {

    protected Type type;

    public CacheLoadable() {
        this.type = getClass().getGenericSuperclass();
    }

    protected abstract T load();


}
