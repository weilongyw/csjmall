package com.csj.framework.http.callback;

import com.alibaba.fastjson.JSONObject;
import com.csj.framework.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultCallback extends BaseCallback<JSONObject> {

    private Logger logger = LoggerFactory.getLogger(DefaultCallback.class);

    @Override
    public void setupRequest(HttpRequestBase request) {
        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(1000)
                .setSocketTimeout(5000)
                .build();
        request.setConfig(requestConfig);
    }

    @Override
    public void setupEntity(StringEntity entity) {

    }

    @Override
    public int success(HttpResponse resp) {
        JSONObject responseJSON = HttpRequest.getResponseJSON(resp, getResCharset());
        logger.info("rtnMsg:{}", responseJSON);
        this.result = responseJSON;
        return HttpStatus.SC_OK;
    }

    @Override
    public int fail(HttpResponse resp) {
        int code = resp.getStatusLine().getStatusCode();
        return code;
    }


}
