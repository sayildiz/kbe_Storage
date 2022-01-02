package com.sayildiz.kbe_storage.backup_service.file_transfer;

import java.io.IOException;

public interface FileTransferService {
    boolean uploadFile(String localFilePath, String remoteFilePath) throws IOException;
    boolean downloadFile(String localFilePath, String remoteFilePath) throws IOException;
}
