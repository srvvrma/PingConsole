package com.pingconsole.patch.dto;

import java.util.ArrayList;

public class PatchData {
	
	private int revNumber;
	private String author;
	private String jiraId;
	private String date;
	private ArrayList<String> path;
	public PatchData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRevNumber() {
		return revNumber;
	}
	public void setRevNumber(int revNumber) {
		this.revNumber = revNumber;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getJiraId() {
		return jiraId;
	}
	public void setJiraId(String jiraId) {
		this.jiraId = jiraId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ArrayList<String> getPath() {
		return path;
	}
	public void setPath(ArrayList<String> path) {
		this.path = path;
	}
	
	

}
