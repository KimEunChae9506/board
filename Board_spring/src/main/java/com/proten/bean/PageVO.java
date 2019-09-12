package com.proten.bean;

public class PageVO {

	private int page;
	private int rowStart;
	private int perPageNum;
	
	public PageVO() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	
	public int getRowStart() {
		return (page - 1) * perPageNum;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		}else {
			this.page = page;
		}	
	}

	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	
	
}
