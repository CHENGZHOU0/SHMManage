package com.shm.bean;

import java.util.Date;

/**
 * 对应数据库中的project表，存放项目数据
 * @author 19204
 *
 */
public class Project {
	private int id;
	private String name;
	private String address;
	private String startTime;
	private String fileId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
}
