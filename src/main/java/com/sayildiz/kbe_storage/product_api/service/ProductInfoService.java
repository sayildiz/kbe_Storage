package com.sayildiz.kbe_storage.product_api.service;

import com.sayildiz.kbe_storage.product_api.model.ProductInfo;

import java.util.List;
import java.util.UUID;

public interface ProductInfoService {
    ProductInfo getByUuid(UUID uuid);
    List<ProductInfo> getAll();


}
