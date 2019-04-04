package com.csj.framework.http.callback;

import lombok.Data;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Data
public abstract class BaseCallback<T> {

    protected T result;

    public T getResult() {
        return result;
    }

    public abstract void setupRequest(HttpRequestBase request);

    public abstract void setupEntity(StringEntity entity);

    public abstract int success(HttpResponse resp);

    public abstract int fail(HttpResponse resp);

    public Charset getReqCharset(){
        return StandardCharsets.UTF_8;
    }

    public Charset getResCharset(){
        return StandardCharsets.UTF_8;
    }

}
