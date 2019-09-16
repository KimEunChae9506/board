package com.proten.bean;

public class PageVO {

	private int page = 1;
	private int perPageNum = 5;
	

	
	public int getRowStart() {
		return (this.page - 1) * perPageNum;
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
