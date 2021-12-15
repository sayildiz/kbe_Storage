package com.sayildiz.kbe_storage.product_api.controller;

import com.sayildiz.kbe_storage.product_api.model.ProductInfo;
import com.sayildiz.kbe_storage.product_api.service.ProductInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

   @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMethodArgumentTypeMismatchException() {
        return "Bad Request: expects valid UUID like 9ff7de0c-acc9-4cee-a99c-c6fbafa237c9";
    }
}
