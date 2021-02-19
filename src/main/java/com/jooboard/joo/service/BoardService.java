package com.jooboard.joo.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.jooboard.joo.dao.*;
import com.jooboard.joo.util.*;
import com.jooboard.joo.vo.*;

@Repository
public class BoardService {
	@Autowired
	BoardDao bDao;
	//게시글 등록 
	
	//게시글 수정
	public void editBoard(ModelAndView mv, BoardVO bVO, PageUtil page) {
		bDao.editBoard(bVO);
		page.setNowPage(1);
		mv.addObject("VIEW", "/board/boardList.joo");
		mv.addObject("PAGE", page);
		mv.setViewName("board/boardRedirect");
		
		return;
	}
	
	//게시글 삭제
	public void delBoard(ModelAndView mv, BoardVO bVO, PageUtil page) {
		int bno = bVO.getBno();
		bDao.delBoard(bno);
		mv.addObject("VIEW", "/board/boardList.joo");
		mv.addObject("PAGE", page);
		mv.setViewName("board/boardRedirect");
	}
}
