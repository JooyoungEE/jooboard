package com.jooboard.joo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.jooboard.joo.dao.BoardDao;
import com.jooboard.joo.service.BoardService;
import com.jooboard.joo.vo.*;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardDao bDao;

	@Autowired
	BoardService bSrvc;
	
	//게시판 리스트
	@RequestMapping("/boardList.joo") 
	public String board(Model model, PagingCriteria pCri) {
		int total = bDao.getTotal(); 
		List<BoardVO> boardList = bDao.getList(pCri);
		model.addAttribute("boardList", boardList);
		model.addAttribute("paging", new PageMaker(pCri, total));
		return "board/boardList";
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
	public ModelAndView boardEdit(ModelAndView mv, BoardVO bVO) {
		int bno = bVO.getBno();
		System.out.println("test1 "+bVO.getBno());
		List<Map> list = bDao.getEditDetail(bno);

		mv.addObject("LIST", list);
		mv.setViewName("board/boardEdit");
		return mv;
	}
	
	//게시글 수정
	@RequestMapping("/boardEditProc.joo")
	public ModelAndView boardEditProc(BoardVO bVO, ModelAndView mv) {
		bSrvc.editBoard(mv, bVO);
		return mv;
	}
	
	//게시글 삭제
	@RequestMapping("/boardDel.joo")
	public ModelAndView boardDel(ModelAndView mv, BoardVO bVO) {
		bSrvc.delBoard(mv, bVO);
		return mv;
	}
	
	//게시글 작성 폼보기
	@RequestMapping("/boardWrite.joo")
	public ModelAndView boardWrite(ModelAndView mv, BoardVO bVO) {
		System.out.println("############## controller boardWrite");
		
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	//게시글 작성
	@RequestMapping("/boardWriteProc.joo")
	public ModelAndView boardWriteProc(BoardVO bVO, ModelAndView mv) {
		bSrvc.writeBoard(mv, bVO);
		return mv;
	}
}





