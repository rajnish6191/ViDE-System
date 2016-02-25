package com.nit.VIDE.Bean;

import java.io.Serializable;

public class ContentBean implements Serializable{
	
	private String cname;
	private String image;
	private String content;
	private String description;
	private double price;
	private String csubname;
	private String catagery;
	private String topic;
	private String date;
	private String ctype;
	private int booksno;
	private int totalrows;
	
	private int musicno;
	private int mobileno;
	
	
	
	private int cid;

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCsubname() {
		return csubname;
	}

	public void setCsubname(String csubname) {
		this.csubname = csubname;
	}

	public String getCatagery() {
		return catagery;
	}

	public void setCatagery(String catagery) {
		this.catagery = catagery;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public int getBooksno() {
		return booksno;
	}

	public void setBooksno(int booksno) {
		this.booksno = booksno;
	}

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public int getMusicno() {
		return musicno;
	}

	public void setMusicno(int musicno) {
		this.musicno = musicno;
	}

	public int getMobileno() {
		return mobileno;
	}

	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}
	
	

}
