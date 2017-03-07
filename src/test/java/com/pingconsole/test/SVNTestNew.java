package com.pingconsole.test;

import java.io.File;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SVNTestNew {

    public void downloadDir(ChannelSftp sftpChannel, String sourcePath, String destPath) throws SftpException { // With
                                                                                                                // subfolders
                                                                                                                // and all
                                                                                                                // files.
        // Create local folders if absent.
        try {
            new File(destPath).mkdirs();
        } catch (Exception e) {
            System.out.println("Error at : " + destPath);
        }
        sftpChannel.lcd(destPath);

        // Copy remote folders one by one.
        lsFolderCopy(sftpChannel, sourcePath, destPath); // Separated because loops itself inside for subfolders.
        
    }

    private void lsFolderCopy(ChannelSftp sftpChannel, String sourcePath, String destPath) throws SftpException {
        System.out.println(sourcePath);
        try{
        @SuppressWarnings("unchecked")
        Vector<ChannelSftp.LsEntry> list = sftpChannel.ls(sourcePath); // List source directory structure.
        for (ChannelSftp.LsEntry oListItem : list) { // Iterate objects in the list to get file/folder names.
            if (!oListItem.getAttrs().isDir()) { // If it is a file (not a directory).
                if (!(new File(destPath + "/" + oListItem.getFilename())).exists() || (oListItem.getAttrs().getMTime() > Long
                        .valueOf(new File(destPath + "/" + oListItem.getFilename()).lastModified() / (long) 1000)
                        .intValue())) { // Download only if changed later.
                    new File(destPath + "/" + oListItem.getFilename());
                    sftpChannel.get(sourcePath + "/" + oListItem.getFilename(), destPath + "/" + oListItem.getFilename()); // Grab
                                                                                                                           // file
                                                                                                                           // from
                                                                                                                           // source
                                                                                                                           // ([source
                                                                                                                           // filename],
                                                                                                                           // [destination
                                                                                                                           // filename]).
                }
            } else if (!(".".equals(oListItem.getFilename()) || "..".equals(oListItem.getFilename()))) {
                new File(destPath + "/" + oListItem.getFilename()).mkdirs(); // Empty folder copy.
                lsFolderCopy(sftpChannel, sourcePath + "/" + oListItem.getFilename(),
                        destPath + "/" + oListItem.getFilename()); // Enter found folder on server to read its contents and
                                                                   // create locally.
            }
        }
        } catch (SftpException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println("error while access : " + sourcePath);
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String user = "@@@@@@@@@@@";
        String password = "@@@@@@@@";
        String host = "@@@@@@@@@@@@@@";
        int port = 22;

        String remotePath = "@@@@@@@@@@@@@@@@@@";

        JSch jsch = new JSch();
        Session session;
        try {
            session = jsch.getSession(user, host, port);

            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
            System.out.println("Connection established.");
            System.out.println("Crating SFTP Channel.");
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            System.out.println("SFTP Channel created.");
            SVNTestNew new1 = new SVNTestNew();
            new1.downloadDir(sftpChannel, remotePath, "D:\\copy");
            sftpChannel.disconnect();
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("Total time taken : " + elapsedTime);
            System.exit(0);
            
        } catch (JSchException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SftpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}