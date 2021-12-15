package com.sayildiz.kbe_storage.product_api;

import com.opencsv.bean.CsvToBeanBuilder;
import com.sayildiz.kbe_storage.product_api.model.ProductInfo;
import com.sayildiz.kbe_storage.product_api.repository.ProductInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(ProductInfoRepository repository){
        return args -> {
            List<ProductInfo> beans = new CsvToBeanBuilder<ProductInfo>(new FileReader("./src/main/resources/AllData.csv"))
                    .withType(ProductInfo.class).build().parse();
            beans.forEach(x -> log.info("loading ProductInfos" + repository.save(x)));
        };
    }
}
