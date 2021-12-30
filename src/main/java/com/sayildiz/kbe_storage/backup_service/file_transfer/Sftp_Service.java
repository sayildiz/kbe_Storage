package com.sayildiz.kbe_storage.backup_service.file_transfer;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Sftp_Service implements FileTransferService {
    private final Logger logger = LoggerFactory.getLogger(Sftp_Service.class);

    @Value("${sftp.host}")
    private String host;

    @Value("${sftp.port}")
    private Integer port;

    @Value("${sftp.username}")
    private String username;

    @Value("${sftp.password}")
    private String password;

    @Override
    public void uploadFile(String localFilePath, String remoteFilePath) throws IOException {
        SSHClient sshClient = setupSshj();
        try {
            SFTPClient sftpClient = sshClient.newSFTPClient();

            try {
                sftpClient.put(localFilePath, remoteFilePath);
            } finally {
                sftpClient.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sshClient.disconnect();
        }
    }

    public void downloadFile(String localFilePath, String remoteFilePath) throws IOException {
        SSHClient sshClient = setupSshj();
        try {
            SFTPClient sftpClient = sshClient.newSFTPClient();

            try {
                sftpClient.get(remoteFilePath, localFilePath);
            } finally {
                sftpClient.close();
            }

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            sshClient.disconnect();
        }

    }



    private SSHClient setupSshj() throws IOException {
        SSHClient client = new SSHClient();
        client.addHostKeyVerifier(new PromiscuousVerifier());
        client.connect(host, port);
        client.authPassword(username, password);
        return client;
    }
}
