package com.sayildiz.kbe_storage.backup_service.file_transfer;

import java.io.IOException;

public interface FileTransferService {
    void uploadFile(String localFilePath, String remoteFilePath) throws IOException;
    void downloadFile(String localFilePath, String remoteFilePath) throws IOException;
}
