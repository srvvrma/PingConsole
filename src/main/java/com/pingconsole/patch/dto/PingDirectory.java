package com.pingconsole.patch.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PING_DIRECTORY")
public class PingDirectory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int indent = 0;
	private String name;
	private String path;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "directory_ref_fk")
	private List<PingDirectory> directories;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "directory_file_fk")
	private List<PingFile> files;

	public PingDirectory() {
		super();
		this.setIndent(0);
		setDirectories(new ArrayList<PingDirectory>());
		setFiles(new ArrayList<PingFile>());
	}
	
	public PingDirectory(String name) {
		super();
		this.setName(name);
		this.setIndent(0);
		setDirectories(new ArrayList<PingDirectory>());
		setFiles(new ArrayList<PingFile>());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public List<PingDirectory> getDirectories() {
		return directories;
	}

	public void setDirectories(List<PingDirectory> directories) {
		this.directories = directories;
	}

	public List<PingFile> getFiles() {
		return files;
	}

	public void setFiles(List<PingFile> files) {
		this.files = files;
	}
	
	public void addNewDirectory(PingDirectory directory){
		this.directories.add(directory);
	}
	
	public void addNewFile(PingFile file){
		this.files.add(file);
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
