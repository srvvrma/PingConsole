package com.pingconsole.patch.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
	public void setJarFile(String path, PingDirectory jarDir, PrintWriter out)
			throws IOException {
		JarFile file = new JarFile(path);
		Enumeration<JarEntry> entries = file.entries();
		while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			if (!entry.isDirectory()) {
				PingFile pingFile = new PingFile(entry.getName(), "",
						entry.toString());
				pingFile.setPatchPath(jarDir.getName() + "#" + entry.toString());
				jarDir.addNewFile(pingFile);
				pingFile.setIndent(jarDir.getIndent() + 1);
				// neoFileService.saveNeoFile(neoFile);
				// out.append("++++++file:" + entry.getName()
				// + "  " + entry + " \n");
			}
		}
	}

	public void displayDirectoryContents(File dir, PrintWriter out,
			PingDirectory parentDir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					// out.append("directory:" + file.getCanonicalPath() +
					// "\n");
				  PingDirectory childDir = new PingDirectory(file.getName());
					childDir.setIndent(parentDir.getIndent() + 1);
					// System.out.println(file.getCanonicalPath().substring(rootPath.length())
					// +"   "+rootPath);
					childDir.setPath(file.getCanonicalPath().substring(
							rootPath.length() - 1).replace(
									'\\', '/'));
					parentDir.addNewDirectory(childDir);
					displayDirectoryContents(file, out, childDir);
					pingDirectoryService.savePingDirectory(childDir);
				} else {
					if (file.getName().contains(".jar")) {
						// out.append("-----jar:" + file.getCanonicalPath() +
						// "\n");
					  PingDirectory childDir = new PingDirectory(file.getName());
						childDir.setIndent(parentDir.getIndent() + 1);
						childDir.setPath(file.getCanonicalPath().substring(
								rootPath.length() - 1));
						setJarFile(file.getCanonicalPath(), childDir, out);
						pingDirectoryService.savePingDirectory(childDir);
					} else {
						// out.append("++++++file:" + file.getCanonicalPath()
						// + "  " + file.getName() + " \n");

						PingFile pingFile = new PingFile(file.getName(), "", file
								.getCanonicalPath()
								.substring(rootPath.length() - 1)
								.replace('\\', '/'));
						pingFile.setPatchPath(pingFile.getLocation().replace(
								'\\', '/').substring(1));
						pingFile.setIndent(parentDir.getIndent() + 1);
						parentDir.addNewFile(pingFile);
						// neoFileService.saveNeoFile(neoFile);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long Start() throws IOException {
		File currentDir = new File(warPath); // current directory
		long startTime = System.currentTimeMillis();
		long stopTime;
		long elapsedTime = 0;
		pingDirectoryService.cleanAllData();
		PingDirectory rootDir = new PingDirectory("Root");
		rootPath = "^" + currentDir.getCanonicalPath().toString();
		rootDir.setPath(currentDir.getCanonicalPath());
		try (PrintWriter out = new PrintWriter("testdata1.txt")) {

			displayDirectoryContents(currentDir, out, rootDir);
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
		return elapsedTime/60000;
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
	public List<String> generatePatchPath(String patchPath) {
		String[] paths = patchPath.split("\n");
		List<String> tempPath = new ArrayList<>();
		List<Criterion> criterionList = new ArrayList<>();
		int lastIndexOfDot = 0, typeCode;
		for (String path : paths) {
			lastIndexOfDot = path.lastIndexOf(".");
			typeCode = getFileType(path.substring(lastIndexOfDot + 1)
					.replaceAll("\\s", ""));
			switch (typeCode) {
			case 1:
				tempPath.add(path.substring(path.lastIndexOf("/webapp/") + "/webapp/".length())
						.replaceAll("\\s", ""));
				break;

			case 2:
				criterionList.add(queryGeneratorUtils
						.searchAllClassPatchPath(path));
				break;
			case 3:
				criterionList.add(queryGeneratorUtils
						.searchAllOdtPatchPath(path));			
				break;

			case 4:
				criterionList.add(queryGeneratorUtils
						.searchAllJsPatchPath(path));
				break;

			case 5:
				criterionList.add(queryGeneratorUtils
						.searchAllXmlPatchPath(path));
				break;

			case 6:
				criterionList.add(queryGeneratorUtils
						.searchAllXlsPatchPath(path));
				break;

			case 7:
				criterionList.add(queryGeneratorUtils
						.searchAllProperPatchPath(path));
				break;

			default:
				break;
			}

		}

		if(!criterionList.isEmpty()){
			for (Iterator iterator = queryGeneratorUtils
					.executeSearch(criterionList).iterator(); iterator
					.hasNext();) {
				tempPath.add(((PingFile) iterator.next()).getPatchPath());
			}
		}
		return tempPath;
	}

}
