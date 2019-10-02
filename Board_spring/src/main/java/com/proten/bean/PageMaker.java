package com.proten.bean;

public class PageMaker {
	private PageVO pvo;
    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;
    private int perPageBt = 5; //한 화면에 보여질 페이지 버튼 수
  
    
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
		calcPage();
	}
	
	public void calcPage() {
		int totalPage = (int) (Math.ceil(totalCount /(double) pvo.getPerPageNum()));
    	endPage = (int) (Math.ceil(pvo.getPage() / (double) perPageBt) * perPageBt);
    	
    	startPage = (endPage - perPageBt) + 1;
    	
    	if(endPage > totalPage) {
    		endPage = totalPage;
    	}
    	
    	if(startPage <= 0) {
    		startPage = 1;
    	}
    	
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
		return getStartPage() != 1;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {//곱의 값이 같으면 마지막페이지라 다음 버튼 x
		return endPage * pvo.getPerPageNum() < getTotalCount();
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
}
