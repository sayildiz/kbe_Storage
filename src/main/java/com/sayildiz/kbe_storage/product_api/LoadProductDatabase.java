package com.sayildiz.kbe_storage.product_api;

import com.opencsv.bean.CsvToBeanBuilder;
import com.sayildiz.kbe_storage.product_api.model.ProductInfo;
import com.sayildiz.kbe_storage.product_api.repository.ProductInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.util.List;

@Configuration
public class LoadProductDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadProductDatabase.class);
    private File csvFileStorageData;


    @Bean
    CommandLineRunner initDatabase(ProductInfoRepository repository){
        return args -> {
                    csvFileStorageData = ResourceUtils.getFile("classpath:StorageData.csv");
                    List<ProductInfo> beans = new CsvToBeanBuilder<ProductInfo>(new FileReader(csvFileStorageData))
                            .withType(ProductInfo.class).build().parse();
                    beans.forEach(x -> log.info("loading ProductInfos for Product API " + repository.save(x)));
            };
    }
}
