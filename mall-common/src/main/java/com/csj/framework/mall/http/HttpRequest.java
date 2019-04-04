package com.csj.framework.mall.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.csj.framework.mall.http.callback.BaseCallback;
import com.csj.framework.mall.http.callback.DefaultCallback;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.*;

public class HttpRequest {

    private static Logger log = LoggerFactory.getLogger(HttpRequest.class);

    public static JSONObject get(String url, Map<String, String> params) {
        JSONObject result = null;
        DefaultCallback callback = new DefaultCallback();
        int ret = get(url, params, callback);
        if (ret == HttpStatus.SC_OK) {
            result = callback.getResult();
        }
        return result;
    }


    public static int get(String url, Map<String, String> params, BaseCallback callback) {
        if (null == callback) {
            return HTTP_ERROR_CALLBACK_NOT_BE_NULL;
        }
        CloseableHttpClient client = getClient(url.startsWith("https"));
        if (null == client) {
            return HTTP_ERROR_CLENT;
        }
        String surl = url;
        String queryString = "";
        try {
            if (null != params) {
                if (surl.lastIndexOf("?") < 0) {
                    surl += "?";
                } else {
                    surl += "&";
                }
                Set<String> keys = params.keySet();
                for (String key : keys) {
                    if (null != params.get(key)) {
                        queryString += "&" + key + "=" + URLEncoder.encode(params.get(key).toString(), "UTF-8");
                    }
                }
                if (queryString.length() > 0) {
                    queryString = queryString.substring(1);
                }
            }
            surl += queryString;
            HttpGet get = new HttpGet(surl);
            get.setHeader("Pragma", "no-cache");
            get.setHeader("Cache-Control", "no-cache");
            CloseableHttpResponse response = client.execute(get);
            int statusCode = response.getStatusLine().getStatusCode();
            log.debug("请求url:{} 返回码:{}", url, statusCode);
            if (statusCode == HttpStatus.SC_OK) {
                return callback.success(response);
            } else {
                return callback.fail(response);
            }
        } catch (HttpHostConnectException socketEx) {
            return HTTP_ERROR_TIMEOUT;
        } catch (UnsupportedEncodingException e1) {
            return HTTP_ERROR_SET_ENTITY;
        } catch (Exception e2) {
            return HTTP_ERROR_NET_WORK;
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static JSONObject post(String url, Map<String, String> params, ReqType reqType) {
        JSONObject result = null;
        DefaultCallback callback = new DefaultCallback();
        int ret = post(url, params, reqType, callback);
        if (ret == HttpStatus.SC_OK) {
            result = callback.getResult();
        }
        return result;
    }

    /**
     * @param url
     * @param params
     * @param reqType
     * @param callback
     * @return
     */
    public static int post(String url, Map<String, String> params, ReqType reqType, BaseCallback callback) {
        if (null == params) {
            return HTTP_ERROR_PARAMS_NOT_BE_NULL;
        }
        if (null == callback) {
            return HTTP_ERROR_CALLBACK_NOT_BE_NULL;
        }
        CloseableHttpClient client = getClient(url.startsWith("https"));
        if (null == client) {
            return HTTP_ERROR_CLENT;
        }
        StringEntity stringEntity = null;
        try {
            switch (reqType) {
                case JSON:
                    params = params == null ? new HashMap<>() : params;
                    stringEntity = new StringEntity(JSON.toJSONString(params), callback.getReqCharset());
                    stringEntity.setContentType("application/json");
                    break;
                case KV:
                    List<NameValuePair> nameValuePairList = new ArrayList<>();
                    if (null != params) {
                        for (String key : params.keySet()) {
                            nameValuePairList.add(new BasicNameValuePair(key, params.get(key)));
                        }
                    }
                    stringEntity = new UrlEncodedFormEntity(nameValuePairList, callback.getReqCharset());
                    stringEntity.setContentType("application/x-www-form-urlencoded");
                    break;
            }
            HttpPost post = new HttpPost(new URI(url));
            post.setEntity(stringEntity);
            CloseableHttpResponse response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            log.debug("请求url:{} 请求参数:{} 返回码:{}", url, params, statusCode);
            if (statusCode == HttpStatus.SC_OK) {
                return callback.success(response);
            } else {
                return callback.fail(response);
            }
        } catch (UnsupportedEncodingException e1) {
            return HTTP_ERROR_SET_ENTITY;
        } catch (HttpHostConnectException socketEx) {
            return HTTP_ERROR_TIMEOUT;
        } catch (Exception e2) {
            return HTTP_ERROR_NET_WORK;
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取client
     *
     * @param ssl
     * @return
     */
    private static CloseableHttpClient getClient(boolean ssl) {
        if (ssl) {
            try {
                // 在调用SSL之前需要重写验证方法，取消检测SSL
                X509TrustManager trustManager = new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] xcs, String str) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] xcs, String str) {
                    }
                };
                SSLContext ctx = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
                ctx.init(null, new TrustManager[]{trustManager}, null);
                SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);
                // 创建Registry
                RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
                        .setExpectContinueEnabled(Boolean.TRUE).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
                        .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
                Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.INSTANCE)
                        .register("https", socketFactory).build();
                // 创建ConnectionManager，添加Connection配置信息
                PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
                CloseableHttpClient closeableHttpClient = HttpClients.custom().setConnectionManager(connectionManager)
                        .setDefaultRequestConfig(requestConfig).build();
                return closeableHttpClient;
            } catch (Exception ex) {
                return null;
            }
        } else {
            return HttpClients.createDefault();
        }
    }


    /**
     * 获取Response的文本内容
     *
     * @param resp as HttpResponse
     * @return String
     * @throws IOException
     */
    public static String getResponseText(HttpResponse resp) {
        return getResponseText(resp, StandardCharsets.UTF_8);
    }

    /**
     * 获取Response的文本内容
     *
     * @param resp as HttpResponse
     * @return String
     * @throws IOException
     */
    public static String getResponseText(HttpResponse resp, Charset charset) {
        String txt = null;
        try {
            HttpEntity entity = resp.getEntity();
            txt = EntityUtils.toString(resp.getEntity(), charset);
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return txt;
    }

    /**
     * 获取Response的json内容
     *
     * @param resp
     * @return
     */
    public static JSONObject getResponseJSON(HttpResponse resp) {
        return getResponseJSON(resp, StandardCharsets.UTF_8);
    }

    /**
     * 获取Response的json内容
     *
     * @param resp
     * @param charsert
     * @return
     */
    public static JSONObject getResponseJSON(HttpResponse resp, Charset charsert) {
        JSONObject obj = null;
        try {
            HttpEntity entity = resp.getEntity();
            String txt = EntityUtils.toString(entity, charsert);
            EntityUtils.consume(entity);
            if (txt != null) {
                obj = JSONObject.parseObject(txt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


    public enum ReqType {
        JSON, KV
    }


    /**
     * 客户端异常
     */
    public static final int HTTP_ERROR_CLENT = 9999;
    /**
     * 请求参数异常
     */
    public static final int HTTP_ERROR_SET_ENTITY = 1000;
    /**
     * 请求超时
     */
    public static final int HTTP_ERROR_TIMEOUT = 1001;
    /**
     * 网络异常
     */
    public static final int HTTP_ERROR_NET_WORK = 1002;
    /**
     * 请求参数不能为空
     */
    public static final int HTTP_ERROR_PARAMS_NOT_BE_NULL = 1003;
    /**
     * 回调函数不能空
     */
    public static final int HTTP_ERROR_CALLBACK_NOT_BE_NULL = 1004;


}
