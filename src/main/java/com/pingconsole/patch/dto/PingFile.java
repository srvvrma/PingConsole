package com.pingconsole.patch.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PING_FILE")
public class PingFile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int indent = 0;
	private String name;
	private String type;
	private String location;
	private String patchWarCode;
	/*@ElementCollection
	@CollectionTable(name="PATCH_PATH")
	@JoinColumn(name="file_id")
	private List<String> patchPath;*/
	
	private String patchPath;
	public PingFile() {
		super();
	}
	
	public PingFile(String name, String type, String location, String patchWarCode) {
		super();
		this.setName(name);
		this.setType(type);
		this.setLocation(location);
		this.setPatchPath(new String());
		this.setPatchWarCode(patchWarCode);
	}
	
	public PingFile(String name,String type,String location) {
		this.setName(name);
		this.setType(type);
		this.setLocation(location);
		this.setPatchPath(new String());
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

/*	public List<String> getPatchPath() {
		return patchPath;
	}

	public void setPatchPath(List<String> patchPath) {
		this.patchPath = patchPath;
	}
	
	public void addNewPatchPath(String path) {
		this.patchPath.add(path);
	}*/
	public String getPatchPath() {
		return patchPath;
	}

	public void setPatchPath(String patchPath) {
		this.patchPath = patchPath;
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	public String getPatchWarCode() {
		return patchWarCode;
	}

	public void setPatchWarCode(String patchWarCode) {
		this.patchWarCode = patchWarCode;
	}

	
}
