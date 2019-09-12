package com.proten.bean;

public class PageMaker {
	private PageVO pvo;
    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;
    private int pageBt = 5; //보여질 페이지 버튼 수
    
    
	public PageVO getPvo() {
		return pvo;
	}
	public void setPvo(PageVO pvo) {
		this.pvo = pvo;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getPageBt() {
		return pageBt;
	}
	public void setPageBt(int pageBt) {
		this.pageBt = pageBt;
	}

}
