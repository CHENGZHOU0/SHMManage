package com.shm.bean;

/**
 * 对应数据库中的userproject表，存放用户数据表
 * @author 19204
 *
 */
public class UserProject {
	private int id;
	private int pid;
	private int uid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	} 
}
