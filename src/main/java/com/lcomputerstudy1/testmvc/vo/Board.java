package com.lcomputerstudy1.testmvc.vo;

public class Board {
	
	
	private String b_title;
	private int b_count;
	private String b_content;
	private String b_date;
	private String b_writer;
	private int b_idx;
	
	public String getb_title() {
		return  b_title;
	}
	public void setb_title(String b_title) {
		this.b_title =  b_title;
	}
	public int getb_count() {
		return b_count;
	}
	public void setb_count(int b_count) {
		this.b_count = b_count;
	}
	public String getb_content() {
		return b_content;
	}
	public void setb_content(String b_content) {
		this.b_content = b_content;
	}
	public String getb_date() {
		return b_date;
	}
	public void setb_date(String b_date) {
		this.b_date = b_date;
	}
	public String getb_writer() {
		return b_writer;
	}
	public void setb_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public int getb_idx() {
		return b_idx;
	}
	public void setb_idx(int b_idx) {
		this.b_idx = b_idx;
	}
}