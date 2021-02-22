package com.jooboard.joo.vo;

public class PagingCriteria {
	private int pageNum = 1;
	private int amount = 5;
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
