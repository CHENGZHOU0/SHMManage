package com.shm.bean;

/**
 * 对应数据库中的sensortype表，存放传感器类型数据
 * @author 19204
 *
 */
public class SensorType {
	private int id;
	private String name;
	private String parameter1;
	private float upperlimit1;
	private float lowerlimit1;
	private String parameter2;
	private float upperlimit2;
	private float lowerlimit2;
	private String parameter3;
	private float upperlimit3;
	private float lowerlimit3;
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
	public String getParameter1() {
		return parameter1;
	}
	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}
	public float getUpperlimit1() {
		return upperlimit1;
	}
	public void setUpperlimit1(float upperlimit1) {
		this.upperlimit1 = upperlimit1;
	}
	public float getLowerlimit1() {
		return lowerlimit1;
	}
	public void setLowerlimit1(float lowerlimit1) {
		this.lowerlimit1 = lowerlimit1;
	}
	public String getParameter2() {
		return parameter2;
	}
	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}
	public float getUpperlimit2() {
		return upperlimit2;
	}
	public void setUpperlimit2(float upperlimit2) {
		this.upperlimit2 = upperlimit2;
	}
	public float getLowerlimit2() {
		return lowerlimit2;
	}
	public void setLowerlimit2(float lowerlimit2) {
		this.lowerlimit2 = lowerlimit2;
	}
	public String getParameter3() {
		return parameter3;
	}
	public void setParameter3(String parameter3) {
		this.parameter3 = parameter3;
	}
	public float getUpperlimit3() {
		return upperlimit3;
	}
	public void setUpperlimit3(float upperlimit3) {
		this.upperlimit3 = upperlimit3;
	}
	public float getLowerlimit3() {
		return lowerlimit3;
	}
	public void setLowerlimit3(float lowerlimit3) {
		this.lowerlimit3 = lowerlimit3;
	}
	
}
