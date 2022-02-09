package com.sayildiz.kbe_storage.backup_service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.sayildiz.kbe_storage.backup_service.file_transfer.FileTransferService;
import com.sayildiz.kbe_storage.backup_service.model.ProductDetails;
import com.sayildiz.kbe_storage.backup_service.repository.ProductRepository;
import com.sayildiz.kbe_storage.productinfo_api.LoadProductDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class LoadBackupDatabase {
    private static final Logger logger = LoggerFactory.getLogger(LoadProductDatabase.class);
    private final String csvPathAllData = System.getProperty("java.io.tmpdir") + "AllData.csv";

    @Autowired
    private FileTransferService fileTransferService;

    @Autowired
    private ProductRepository repository;

    @Scheduled(fixedDelay = 3600, timeUnit = TimeUnit.SECONDS)
    public void initBackupDatabase(){
            logger.info("Start download file");
        try {
            if(fileTransferService.downloadFile(csvPathAllData, "/upload/AllData.csv")) {
                List<ProductDetails> beans = new CsvToBeanBuilder<ProductDetails>(new FileReader(csvPathAllData))
                        .withType(ProductDetails.class).build().parse();
                beans.forEach(x -> logger.info("loading Product for BackupService " + repository.save(x)));
            }else{
                logger.error("Could not load AllData.csv from SFTP Service");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
