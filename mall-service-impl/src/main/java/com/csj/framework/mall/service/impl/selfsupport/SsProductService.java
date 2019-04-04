package com.csj.framework.mall.service.impl.selfsupport;

import com.alibaba.fastjson.JSONObject;
import com.csj.framework.common.response.BaseResponse;
import com.csj.framework.common.response.data.WorkPageData;
import com.csj.framework.mall.entity.selfsupport.SsBrand;
import com.csj.framework.exception.BizException;
import com.csj.framework.exception.ErrorEnum;
import com.csj.framework.http.HttpRequest;
import com.csj.framework.properties.OutfaceUrlProperties;
import com.csj.framework.mall.vo.CategoryVO;
import com.csj.framework.mall.vo.SsStdSkuProductVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SsProductService {

    @Autowired
    OutfaceUrlProperties outfaceUrlProperties;

    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
            .create();

    public BaseResponse<List<CategoryVO>> listCategory() {
        JSONObject result = HttpRequest.get(outfaceUrlProperties.getCategoryList(), null);
        if (result != null) {
            Type type = new TypeToken<BaseResponse<List<CategoryVO>>>() {
            }.getType();
            return gson.fromJson(result.toString(), type);
        } else {
            throw new BizException(ErrorEnum.BIZ_SEARCH_FAIL);
        }
    }

    public BaseResponse<List<SsBrand>> listBrand(String categoryId, String categoryCode) {
        Map<String, String> params = new HashMap<>();
        params.put("id", categoryId);
        params.put("classCode", categoryCode);
        JSONObject result = HttpRequest.get(outfaceUrlProperties.getBrandList(), params);
        if (result != null) {
            Type type = new TypeToken<BaseResponse<List<SsBrand>>>() {
            }.getType();
            return gson.fromJson(result.toString(), type);
        } else {
            throw new BizException(ErrorEnum.BIZ_SEARCH_FAIL);
        }
    }

    public BaseResponse<WorkPageData<SsStdSkuProductVO>> pageProductData() {
        JSONObject result = HttpRequest.get(outfaceUrlProperties.getProductSkuList(), null);
        if (result != null) {
            Type type = new TypeToken<BaseResponse<WorkPageData<SsStdSkuProductVO>>>() {
            }.getType();
            return gson.fromJson(result.toString(), type);
        } else {
            throw new BizException(ErrorEnum.BIZ_SEARCH_FAIL);
        }
    }

    public BaseResponse<SsStdSkuProductVO> getProductById(String productId) {
        Map<String, String> params = new HashMap<>();
        params.put("id", productId);
        JSONObject result = HttpRequest.get(outfaceUrlProperties.getProductSkuDetail(), params);
        if (result != null) {
            Type type = new TypeToken<BaseResponse<SsStdSkuProductVO>>() {
            }.getType();
            return gson.fromJson(result.toString(), type);
        } else {
            throw new BizException(ErrorEnum.BIZ_SEARCH_FAIL);
        }
    }
}
