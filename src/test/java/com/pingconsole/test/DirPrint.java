package com.pingconsole.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.pingconsole.patch.dto.PingDirectory;
import com.pingconsole.patch.dto.PingFile;

public class DirPrint {

	public static void main(String[] args) {
		File currentDir = new File("D:\\webapp\\"); // current directory
		long startTime = System.currentTimeMillis();
		long stopTime;
		long elapsedTime;
		PingDirectory RootDir = new PingDirectory("Root");
		try (PrintWriter out = new PrintWriter("D:\\testdata1.txt")) {

			displayDirectoryContents(currentDir, out, RootDir);
			stopTime = System.currentTimeMillis();
			elapsedTime = stopTime - startTime;
			out.append("Total time : " + elapsedTime);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("resource")
	public static void setJarFile(String path,PingDirectory jarDir,PrintWriter out) throws IOException{
		JarFile file = new JarFile(path);
		Enumeration<JarEntry> entries = file.entries();
		while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			if (!entry.isDirectory()){
				PingFile pingFile = new PingFile(entry.getName(), "",entry.toString());
				jarDir.addNewFile(pingFile);
				out.append("++++++file:" + entry.getName()
						+ "  " + entry + " \n");
			}
		}
	}

	public static void displayDirectoryContents(File dir, PrintWriter out,
			PingDirectory parentDir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					out.append("directory:" + file.getCanonicalPath() + "\n");
					PingDirectory childDir = new PingDirectory(file.getName());
					childDir.setIndent(parentDir.getIndent() + 1);
					parentDir.addNewDirectory(childDir);
					displayDirectoryContents(file, out, childDir);
				} else {
					if (file.getName().contains(".jar")) {
						out.append("-----jar:" + file.getCanonicalPath() + "\n");
						setJarFile(file.getCanonicalPath(), new PingDirectory(), out);
					}else{
						out.append("++++++file:" + file.getCanonicalPath()
								+ "  " + file.getName() + " \n");

						PingFile pingFile = new PingFile(file.getName(), "",
								file.getCanonicalPath());
						pingFile.setIndent(parentDir.getIndent());
						parentDir.addNewFile(pingFile);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}