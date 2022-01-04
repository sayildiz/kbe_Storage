package com.sayildiz.kbe_storage.productinfo_api.repository;

import com.sayildiz.kbe_storage.productinfo_api.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, UUID> {
    ProductInfo findByUuid(UUID uuid);
}
