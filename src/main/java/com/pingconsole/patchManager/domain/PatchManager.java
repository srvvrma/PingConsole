package com.pingconsole.patchManager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.pingconsole.environment.domain.Environment;

@Entity
public class PatchManager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Environment environment;
	private String name;
	private String code;
	private String description;
	private String svnLocation;
	
	public Long getId() {
		return id;
	}
	public Environment getEnvironment() {
		return environment;
	}
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSvnLocation() {
		return svnLocation;
	}
	public void setSvnLocation(String svnLocation) {
		this.svnLocation = svnLocation;
	}
	
}
