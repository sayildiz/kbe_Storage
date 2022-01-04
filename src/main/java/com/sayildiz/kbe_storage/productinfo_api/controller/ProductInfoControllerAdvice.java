package com.sayildiz.kbe_storage.productinfo_api.controller;

import com.sayildiz.kbe_storage.productinfo_api.exception.ProductInfoNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductInfoControllerAdvice {
    private static final Logger logger =
            LoggerFactory.getLogger(ProductInfoControllerAdvice.class);
    @ResponseBody
    @ExceptionHandler(ProductInfoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productInfoNotFoundHandler(ProductInfoNotFoundException exception){
        logger.info("ProductInfoNotFoundException: " + exception.getMessage());
        return exception.getMessage();
    }
}
