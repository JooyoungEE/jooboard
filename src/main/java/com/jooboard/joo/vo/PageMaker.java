package com.jooboard.joo.vo;

public class PageMaker {
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private PagingCriteria cri;
	
	public PageMaker(PagingCriteria cri, int total) {
		this.cri = cri;
		this.startPage = (int)(cri.getPageNum()%cri.getBlock()) == 0 ? (cri.getPageNum()-9) : (int)((Math.floor(cri.getPageNum() * 0.1)) * 10 + 1);
		int realEnd = startPage + 9;
		this.endPage = (int)((total%cri.getAmount()) == 0 ? Math.floor(total/cri.getAmount()) : Math.floor(total/cri.getAmount()) + 1);
		
		this.next = getEndPage() > realEnd;
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = cri.getPageNum() > cri.getBlock();
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

	public PagingCriteria getCri() {
		return cri;
	}

	public void setCri(PagingCriteria cri) {
		this.cri = cri;
	}
	
}
