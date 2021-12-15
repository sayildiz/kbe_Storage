package com.sayildiz.kbe_storage.product_api.controller;

import com.sayildiz.kbe_storage.product_api.model.ProductInfo;
import com.sayildiz.kbe_storage.product_api.service.ProductInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductInfoController {

    private final ProductInfoService productInfoService;

    public ProductInfoController(ProductInfoService productInfoService) {
        this.productInfoService = productInfoService;
    }


    @GetMapping("/productinfo")
    public List<ProductInfo> getProductInfos(){
        return productInfoService.getAll();
    }

    @GetMapping("/productinfo/{uuid}")
    public ProductInfo getProductInfoById(@PathVariable UUID uuid){
        return productInfoService.getByUuid(uuid);
    }
}
