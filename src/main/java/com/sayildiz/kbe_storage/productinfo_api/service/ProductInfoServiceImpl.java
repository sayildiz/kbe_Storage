package com.sayildiz.kbe_storage.productinfo_api.service;

import com.sayildiz.kbe_storage.productinfo_api.exception.ProductInfoNotFoundException;
import com.sayildiz.kbe_storage.productinfo_api.model.ProductInfo;
import com.sayildiz.kbe_storage.productinfo_api.repository.ProductInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductInfoServiceImpl implements ProductInfoService{
    private  final ProductInfoRepository repository;

    public ProductInfoServiceImpl(ProductInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductInfo getByUuid(UUID uuid) {
        return this.repository.findById(uuid)
                .orElseThrow(()-> new ProductInfoNotFoundException(uuid));
    }

    @Override
    public List<ProductInfo> getAll() {
        return this.repository.findAll();
    }
}
