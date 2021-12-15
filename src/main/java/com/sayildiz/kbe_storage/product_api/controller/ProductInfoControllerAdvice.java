package com.sayildiz.kbe_storage.product_api.controller;

import com.sayildiz.kbe_storage.product_api.exception.ProductInfoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductInfoControllerAdvice {
    @ResponseBody
    @ExceptionHandler(ProductInfoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productInfoNotFoundHandler(ProductInfoNotFoundException exception){
        return exception.getMessage();
    }
}
