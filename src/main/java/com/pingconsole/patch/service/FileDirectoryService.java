package com.pingconsole.patch.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.pingconsole.patch.dto.PingDirectory;
import com.pingconsole.patch.dto.PingFile;
import com.pingconsole.patch.util.QueryGeneratorUtils;

@Service
public class FileDirectoryService {

	@Autowired
	private QueryGeneratorUtils queryGeneratorUtils;
	@Autowired
	private PingDirectoryService pingDirectoryService;

	@Value("${warPath}")
	private String warPath;

	String rootPath;

	static String JSP = "jsp";
	static String CLASS = "java";
	static String ODT = "odt";
	static String JS = "js";
	static String XML = "xml";
	static String XLS = "xls";
	static String PROPERTIES = "properties";

	static String OTHER = "other";

	private static int JSP_CODE = 1;
	static int CLASS_CODE = 2;
	static int ODT_CODE = 3;
	static int JS_CODE = 4;
	static int XML_CODE = 5;
	static int XLS_CODE = 6;
	static int PROPERTIES_CODE = 7;

	static int OTHER_CODE = 100;

	// @Autowired
	// NeoFileService neoFileService;

	@SuppressWarnings("resource")
	public void setJarFile(String path, PingDirectory jarDir, PrintWriter out,String patchWarCode) throws IOException {
		JarFile file = new JarFile(path);
		Enumeration<JarEntry> entries = file.entries();
		while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			if (!entry.isDirectory()) {
				PingFile pingFile = new PingFile(entry.getName(), "", entry.toString());
				pingFile.setPatchPath(jarDir.getName() + "#" + entry.toString());
				jarDir.addNewFile(pingFile);
				pingFile.setIndent(jarDir.getIndent() + 1);
				pingFile.setPatchWarCode(patchWarCode);
				// neoFileService.saveNeoFile(neoFile);
				// out.append("++++++file:" + entry.getName()
				// + " " + entry + " \n");
			}
		}
	}

	public void displayDirectoryContents(File dir, PrintWriter out, PingDirectory parentDir, String patchWarCode) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					// out.append("directory:" + file.getCanonicalPath() +
					// "\n");
					PingDirectory childDir = new PingDirectory(file.getName(), patchWarCode);
					childDir.setIndent(parentDir.getIndent() + 1);
					// System.out.println(file.getCanonicalPath().substring(rootPath.length())
					// +" "+rootPath);
					childDir.setPath(file.getCanonicalPath().substring(rootPath.length() - 1).replace('\\', '/'));
					parentDir.addNewDirectory(childDir);
					parentDir.setPatchWarCode(patchWarCode);
					displayDirectoryContents(file, out, childDir, patchWarCode);
					pingDirectoryService.savePingDirectory(childDir);
				} else {
					if (file.getName().contains(".jar")) {
						// out.append("-----jar:" + file.getCanonicalPath() +
						// "\n");
						PingDirectory childDir = new PingDirectory(file.getName());
						childDir.setIndent(parentDir.getIndent() + 1);
						childDir.setPatchWarCode(patchWarCode);
						childDir.setPath(file.getCanonicalPath().substring(rootPath.length() - 1));
						setJarFile(file.getCanonicalPath(), childDir, out,patchWarCode);
						pingDirectoryService.savePingDirectory(childDir);
					} else {
						// out.append("++++++file:" + file.getCanonicalPath()
						// + " " + file.getName() + " \n");

						PingFile pingFile = new PingFile(file.getName(), "",
								file.getCanonicalPath().substring(rootPath.length() - 1).replace('\\', '/'),
								patchWarCode);
						pingFile.setPatchPath(pingFile.getLocation().replace('\\', '/').substring(1));
						pingFile.setIndent(parentDir.getIndent() + 1);
						pingFile.setPatchWarCode(patchWarCode);
						parentDir.addNewFile(pingFile);
						// neoFileService.saveNeoFile(neoFile);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long Start(String patchWarCode) throws IOException {
		File currentDir = new File(warPath); // current
																	// directory
		long startTime = System.currentTimeMillis();
		long stopTime;
		long elapsedTime = 0;
		pingDirectoryService.cleanAllFileForCode(patchWarCode);
		pingDirectoryService.cleanAllDataForCode(patchWarCode);
		PingDirectory rootDir = new PingDirectory("Root", patchWarCode);
		rootPath = "^" + currentDir.getCanonicalPath().toString();
		rootDir.setPath(currentDir.getCanonicalPath());
		try (PrintWriter out = new PrintWriter("testdata1.txt")) {

			displayDirectoryContents(currentDir, out, rootDir, patchWarCode);
			pingDirectoryService.savePingDirectory(rootDir);
			stopTime = System.currentTimeMillis();
			elapsedTime = stopTime - startTime;
			out.append(rootPath);
			out.append("Total time : " + elapsedTime);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pingDirectoryService.savePingDirectory(rootDir);
		return elapsedTime / 60000;
	}

	private static int getFileType(String type) {
		if (type.equalsIgnoreCase("jsp"))
			return FileDirectoryService.JSP_CODE;
		if (type.equalsIgnoreCase(CLASS))
			return FileDirectoryService.CLASS_CODE;
		if (type.equalsIgnoreCase(FileDirectoryService.JS))
			return FileDirectoryService.JS_CODE;
		if (type.equalsIgnoreCase(FileDirectoryService.ODT))
			return FileDirectoryService.ODT_CODE;
		if (type.equalsIgnoreCase(FileDirectoryService.XML))
			return FileDirectoryService.XML_CODE;
		if (type.equalsIgnoreCase(FileDirectoryService.XLS))
			return FileDirectoryService.XLS_CODE;
		if (type.equalsIgnoreCase(FileDirectoryService.PROPERTIES))
			return FileDirectoryService.PROPERTIES_CODE;
		return FileDirectoryService.OTHER_CODE;

	}

	@SuppressWarnings("rawtypes")
	public List<String> generatePatchPath(String patchPath,String warCode) {
		String[] paths = patchPath.split("\n");
		List<String> tempPath = new ArrayList<>();
		List<Criterion> criterionList = new ArrayList<>();
		int lastIndexOfDot = 0, typeCode;
		for (String path : paths) {
			lastIndexOfDot = path.lastIndexOf(".");
			typeCode = getFileType(path.substring(lastIndexOfDot + 1).replaceAll("\\s", ""));
			switch (typeCode) {
			case 1:
				tempPath.add(path.substring(path.lastIndexOf("/webapp/") + "/webapp/".length()).replaceAll("\\s", ""));
				break;

			case 2:
				criterionList.add(Restrictions.conjunction().add(queryGeneratorUtils.searchAllClassPatchPath(path)).add(Restrictions.ilike("patchWarCode", warCode)));
				break;
			case 3:
				criterionList.add(Restrictions.conjunction().add(queryGeneratorUtils.searchAllOdtPatchPath(path)).add(Restrictions.ilike("patchWarCode", warCode)));
				break;

			case 4:
				criterionList.add(Restrictions.conjunction().add(queryGeneratorUtils.searchAllJsPatchPath(path)).add(Restrictions.ilike("patchWarCode", warCode)));
				break;

			case 5:
				criterionList.add(Restrictions.conjunction().add(queryGeneratorUtils.searchAllXmlPatchPath(path)).add(Restrictions.ilike("patchWarCode", warCode)));
				break;

			case 6:
				criterionList.add(Restrictions.conjunction().add(queryGeneratorUtils.searchAllXlsPatchPath(path)).add(Restrictions.ilike("patchWarCode", warCode)));
				break;

			case 7:
				criterionList.add(Restrictions.conjunction().add(queryGeneratorUtils.searchAllProperPatchPath(path)).add(Restrictions.ilike("patchWarCode", warCode)));
				break;

			default:
				break;
			}

		}

		if (!criterionList.isEmpty()) {
			for (Iterator iterator = queryGeneratorUtils.executeSearch(criterionList).iterator(); iterator.hasNext();) {
				tempPath.add(((PingFile) iterator.next()).getPatchPath());
			}
		}
		return tempPath;
	}

	public long CopyWarFromSVN(String host, int port, String user, String password, String remotePath,String patchCode) {
		long startTime = System.currentTimeMillis();
		long elapsedTime = 0;

		JSch jsch = new JSch();
		Session session = null;
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
			FileUtils.cleanDirectory(new File(warPath));
			downloadDir(sftpChannel, remotePath, warPath);
			sftpChannel.disconnect();
			long stopTime = System.currentTimeMillis();
			elapsedTime = stopTime - startTime;
			System.out.println("Total time taken : " + elapsedTime);
			return elapsedTime;
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SftpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.disconnect();
		}
		return elapsedTime;
	}

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
		lsFolderCopy(sftpChannel, sourcePath, destPath); // Separated because
															// loops itself
															// inside for
															// subfolders.

	}

	private void lsFolderCopy(ChannelSftp sftpChannel, String sourcePath, String destPath) throws SftpException {
		System.out.println(sourcePath);
		try {
			@SuppressWarnings("unchecked")
			Vector<ChannelSftp.LsEntry> list = sftpChannel.ls(sourcePath); // List
																			// source
																			// directory
																			// structure.
			for (ChannelSftp.LsEntry oListItem : list) { // Iterate objects in
															// the list to get
															// file/folder
															// names.
				if (!oListItem.getAttrs().isDir()) { // If it is a file (not a
														// directory).
					if (!(new File(destPath + "/" + oListItem.getFilename())).exists() || (oListItem.getAttrs()
							.getMTime() > Long.valueOf(
									new File(destPath + "/" + oListItem.getFilename()).lastModified() / (long) 1000)
									.intValue())) { // Download only if changed
													// later.
						new File(destPath + "/" + oListItem.getFilename());
						sftpChannel.get(sourcePath + "/" + oListItem.getFilename(),
								destPath + "/" + oListItem.getFilename()); // Grab
						// file
						// from
						// source
						// ([source
						// filename],
						// [destination
						// filename]).
					}
				} else if (!(".".equals(oListItem.getFilename()) || "..".equals(oListItem.getFilename()))) {
					new File(destPath + "/" + oListItem.getFilename()).mkdirs(); // Empty
																					// folder
																					// copy.
					lsFolderCopy(sftpChannel, sourcePath + "/" + oListItem.getFilename(),
							destPath + "/" + oListItem.getFilename()); // Enter
																		// found
																		// folder
																		// on
																		// server
																		// to
																		// read
																		// its
																		// contents
																		// and
					// create locally.
				}
			}
		} catch (SftpException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("error while access : " + sourcePath);
		}
	}

}
