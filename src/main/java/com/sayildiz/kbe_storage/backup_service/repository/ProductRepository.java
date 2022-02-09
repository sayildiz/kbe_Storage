package com.sayildiz.kbe_storage.backup_service.repository;

import com.sayildiz.kbe_storage.backup_service.model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductDetails, UUID> {
    ProductDetails findByUuid(UUID uuid);
}
