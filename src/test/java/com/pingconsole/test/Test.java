package com.pingconsole.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Test {
	public static void main(String[] args) {
		String user = "@@@@@@@@@@@";
		String password = "@@@@@@@@@@@@";
		String host = "@@@@@@@@@@";
		int port = 22;

		String remotePath = "@@@@@@@@@@";

		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, port);
			session.setPassword(password);
			session.setConfig("StrictHostKeyChecking", "no");
			System.out.println("Establishing Connection...");
			session.connect();
			System.out.println("Connection established.");
			System.out.println("Crating SFTP Channel.");
			ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
			sftpChannel.connect();
			System.out.println("SFTP Channel created.");

			InputStream out = null;
			String fileName = null;
			@SuppressWarnings("rawtypes")
			Vector filelist = sftpChannel.ls(remotePath);
            for(int i=0; i<filelist.size();i++){
                //System.out.println(filelist.toString());
                LsEntry entry = (LsEntry) filelist.get(i);
                fileName = entry.getFilename();
                if(fileName.contains("revision")){
                	System.out.println(fileName);
                	out = sftpChannel.get(remotePath+"/"+fileName);
        			BufferedReader br = new BufferedReader(new InputStreamReader(out));
        			String line;
        			while ((line = br.readLine()) != null)
        				System.out.println(line.toString());
        			br.close();
                }
            }
		} catch (Exception e) {
			System.err.print(e);
		}
	}

}
