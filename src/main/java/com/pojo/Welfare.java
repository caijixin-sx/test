package com.pojo;

import java.io.Serializable;

public class Welfare implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer wid;
	private String wname;
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	@Override
	public String toString() {
		return "Welfare [wid=" + wid + ", wname=" + wname + "]";
	}
	public Welfare(Integer wid, String wname) {
		super();
		this.wid = wid;
		this.wname = wname;
	}
	public Welfare() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
