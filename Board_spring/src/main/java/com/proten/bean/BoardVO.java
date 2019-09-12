package com.proten.bean;

public class BoardVO {
		//여기선 인서트 같은 구문으로 다 변경될 수 있는 값이니 setter
	private int no;
	private String title;
	private String content;
	private String writer;
	private String regDate;
	private String date;
	private int viewCnt;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {//필드값변경
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	
	
}
