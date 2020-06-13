package com.shm.bean;

import java.util.Date;


/**
 * 对应数据库中的monitoringdata表,存放监测数据
 * @author 19204
 *
 */
public class MonitoringData {
	private int id;
	private String time; 
	private String sensorId;
	private String sensorType;
	private String x;
	private String y;
	private String t;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSensorId() {
		return sensorId;
	}
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	@Override
	public String toString() {
		return "MonitoringData [id=" + id + ", time=" + time + ", sensorId=" + sensorId + ", sensorType=" + sensorType
				+ ", x=" + x + ", y=" + y + ", t=" + t + "]";
	}
	
	
	
}
