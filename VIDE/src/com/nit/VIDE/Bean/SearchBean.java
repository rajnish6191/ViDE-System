package com.nit.VIDE.Bean;

import java.io.Serializable;

public class SearchBean implements Serializable{
	
	private int sid;
	private int uid;
	private String fname;
	private String lname;
	private String content;
	private  String sdate;
	private int count;
	
	private String sdomain;
	
	public String getSdomain() {
		return sdomain;
	}
	public void setSdomain(String sdomain) {
		this.sdomain = sdomain;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	

}
