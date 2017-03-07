package com.neo.test;

import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarPrint {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			JarFile file = new JarFile("d:\\***.jar");
			Enumeration<JarEntry> entries = file.entries();
			while (entries.hasMoreElements()) {
				JarEntry entry = entries.nextElement();
				if (entry.isDirectory())
					System.out.println(entry + " : Dir Entry");
				else
					System.out.println(entry + " : File Entry");
			}
		} catch (Exception er) {
			er.printStackTrace();
		}

	}

}
