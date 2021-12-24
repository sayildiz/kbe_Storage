package com.sayildiz.kbe_storage.backup_service;

public interface FileTransferService {
    //boolean uploadFile(String localFilePath, String remoteFilePath);
    boolean downloadFile(String localFilePath, String remoteFilePath);
}
