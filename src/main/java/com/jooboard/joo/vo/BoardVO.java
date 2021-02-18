package com.jooboard.joo.vo;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class BoardVO {
	private int bno;
	private String title, body, writer, bdate, isshow;
	private Date wdate;
	private Time wtime;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		bdate = form.format(wdate);
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public Time getWtime() {
		return wtime;
	}
	public void setWtime(Time wtime) {
		this.wtime = wtime;
	}
	
	
}
