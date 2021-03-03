package com.jooboard.joo.controller;

public class PagingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nowPage = 18;
		int totalCount = 432;
		int block = 10;
		int amount = 5;
		int startPage = 1;

		int realStart = (int)(nowPage%block) == 0 ? (nowPage-9) : (int)((Math.floor(nowPage * 0.1)) * 10 + 1);
		int realEnd = realStart + 9;
		int endPage = (int)((totalCount%amount) == 0 ? Math.floor(totalCount/amount) : Math.floor(totalCount/amount) + 1);
		
		
		if(nowPage > block) {
			System.out.println("이전");
		}
		System.out.println("totalCount : "+totalCount);
		System.out.println("startPage : "+startPage);
		System.out.println("realStart : "+realStart);
		System.out.println("realEnd : "+realEnd);
		System.out.println("endPage : "+endPage);
		
		if(realEnd < endPage) {
			System.out.println("다음");
		}
	}

}
