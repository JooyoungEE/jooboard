package com.jooboard.joo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.jooboard.joo.dao.*;
import com.jooboard.joo.vo.*;

@Repository
public class BoardService {
	@Autowired
	BoardDao bDao;
	
	//게시글 등록 
	public void writeBoard(ModelAndView mv, BoardVO bVO) {
		bDao.writeBoard(bVO);
		mv.addObject("VIEW", "/board/boardList.joo");
		mv.setViewName("board/boardRedirect");
	}
	//게시글 수정
	public void editBoard(ModelAndView mv, BoardVO bVO) {
		bDao.editBoard(bVO);
		mv.addObject("VIEW", "/board/boardList.joo");
		mv.setViewName("board/boardRedirect");
		
		return;
	}
	
	//게시글 삭제
	public void delBoard(ModelAndView mv, BoardVO bVO) {
		int bno = bVO.getBno();
		bDao.delBoard(bno);
		mv.addObject("VIEW", "/board/boardList.joo");
		mv.setViewName("board/boardRedirect");
	}
	
	//게시글 목록 조회
	List<BoardVO> getList(PagingCriteria paging){
		return bDao.getList(paging);
	}
}

