package com.sayildiz.kbe_storage.backup_service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.sayildiz.kbe_storage.backup_service.file_transfer.FileTransferService;
import com.sayildiz.kbe_storage.backup_service.model.Product;
import com.sayildiz.kbe_storage.backup_service.repository.ProductRepository;
import com.sayildiz.kbe_storage.product_api.LoadProductDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.util.List;

@Configuration
public class LoadBackupDatabase {
    private static final Logger logger = LoggerFactory.getLogger(LoadProductDatabase.class);
    private final String csvPathAllData = "classpath:AllData.csv";

    @Autowired
    private FileTransferService fileTransferService;

    @Bean
    CommandLineRunner initBackupDatabase(ProductRepository repository){
        return args -> {
            logger.info("Start download file");

            fileTransferService.downloadFile(csvPathAllData, "/upload/AllData.csv");

            List<Product> beans = new CsvToBeanBuilder<Product>(new FileReader(csvPathAllData))
                    .withType(Product.class).build().parse();
            beans.forEach(x -> logger.info("loading Product for BackupService " + repository.save(x)));


        };
    }
}
