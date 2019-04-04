package com.csj.framework.mall.controller;

import com.csj.framework.common.response.BaseResponse;
import com.csj.framework.common.response.data.WorkPageData;
import com.csj.framework.mall.entity.selfsupport.SsBrand;
import com.csj.framework.mall.service.impl.selfsupport.SsProductService;
import com.csj.framework.mall.vo.CategoryVO;
import com.csj.framework.mall.vo.SsStdSkuProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    SsProductService productService;

    @GetMapping("/category/list")
    BaseResponse<List<CategoryVO>> listCategory() {
        return productService.listCategory();
    }

    @GetMapping("/brand/list")
    BaseResponse<List<SsBrand>> listBrand(@RequestParam("categoryId") String categoryId, @RequestParam("categoryCode") String categoryCode) {
        return productService.listBrand(categoryId, categoryCode);
    }

    @GetMapping("/product/sku/list")
    BaseResponse<WorkPageData<SsStdSkuProductVO>> listSkuProduct() {
        BaseResponse<WorkPageData<SsStdSkuProductVO>> workPageDataBaseResponse = productService.pageProductData();
        return workPageDataBaseResponse;
    }

    @GetMapping("/product/sku/detail")
    BaseResponse<SsStdSkuProductVO> getProductById(@RequestParam("productId") String productId) {
        return productService.getProductById(productId);
    }


}
