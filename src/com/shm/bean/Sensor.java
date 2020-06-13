package com.shm.bean;

import java.util.Date;

/**
 * 对应数据库中的sensor表，存放传感器数据
 * @author 19204
 *
 */
public class Sensor {
	private int id;
	private String name;
	private Date installingTime;
	private String samplingFrequency;
	private String operationCondition;
	private String maintenanceRecord;
	private int elementId;
	private int stid;
	private int pid;
	
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
	public Date getInstallingTime() {
		return installingTime;
	}
	public void setInstallingTime(Date installingTime) {
		this.installingTime = installingTime;
	}
	public String getSamplingFrequency() {
		return samplingFrequency;
	}
	public void setSamplingFrequency(String samplingFrequency) {
		this.samplingFrequency = samplingFrequency;
	}
	public String getOperationCondition() {
		return operationCondition;
	}
	public void setOperationCondition(String operationCondition) {
		this.operationCondition = operationCondition;
	}
	public String getMaintenanceRecord() {
		return maintenanceRecord;
	}
	public void setMaintenanceRecord(String maintenanceRecord) {
		this.maintenanceRecord = maintenanceRecord;
	}
	public int getElementId() {
		return elementId;
	}
	public void setElementId(int elementId) {
		this.elementId = elementId;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	@Override
	public String toString() {
		return "Sensor [id=" + id + ", name=" + name + ", installingTime=" + installingTime + ", samplingFrequency="
				+ samplingFrequency + ", operationCondition=" + operationCondition + ", maintenanceRecord="
				+ maintenanceRecord + ", elementId=" + elementId + ", stid=" + stid + ", pid=" + pid + "]";
	}
	
	
}
