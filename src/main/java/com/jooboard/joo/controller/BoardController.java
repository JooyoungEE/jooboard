package com.jooboard.joo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.jooboard.joo.dao.BoardDao;
import com.jooboard.joo.service.BoardService;
import com.jooboard.joo.util.PageUtil;
import com.jooboard.joo.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardDao bDao;

	@Autowired
	BoardService bSrvc;
	
	//게시판 리스트
	@RequestMapping("/boardList.joo") 
	public ModelAndView board(ModelAndView mv, PageUtil page) {
		int total = bDao.getTotal();
		page.setPage(total, 5, 5);
		
		List<BoardVO> list = bDao.getList(page);
		
		mv.addObject("PAGE", page);
		mv.addObject("LIST", list);
		
		mv.setViewName("board/boardList");
		return mv;
	}
	
	//게시글 상세보기
	@RequestMapping(value="/boardDetail.joo", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView boardDetail(ModelAndView mv, int bno) {
		BoardVO bVO = bDao.getDetail(bno);
		mv.addObject("DATA", bVO);
		
		mv.setViewName("board/boardDetail");
		return mv;
	}

	//게시글 수정 폼보기
	@RequestMapping(value="/boardEdit.joo", method= {RequestMethod.POST})
	public ModelAndView boardEdit(ModelAndView mv, BoardVO bVO, PageUtil page) {
		int bno = bVO.getBno();
		System.out.println("test1 "+bVO.getBno());
		List<Map> list = bDao.getEditDetail(bno);

		mv.addObject("LIST", list);
		mv.addObject("PAGE", page);
		mv.setViewName("board/boardEdit");
		return mv;
	}
	
	//게시글 수정
	@RequestMapping("/boardEditProc.joo")
	public ModelAndView boardEditProc(BoardVO bVO, ModelAndView mv, PageUtil page) {
		bSrvc.editBoard(mv, bVO, page);
		return mv;
	}
	
	//게시글 삭제
	@RequestMapping("/boardDel.joo")
	public ModelAndView boardDel(ModelAndView mv, BoardVO bVO, PageUtil page) {
		bSrvc.delBoard(mv, bVO, page);
		return mv;
	}
}
