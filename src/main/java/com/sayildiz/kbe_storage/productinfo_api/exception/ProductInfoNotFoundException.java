package com.sayildiz.kbe_storage.productinfo_api.exception;

import java.util.UUID;

public class ProductInfoNotFoundException extends RuntimeException {
    public ProductInfoNotFoundException(UUID uuid){
        super("Could not find song with UUID " + uuid);
    }
}
