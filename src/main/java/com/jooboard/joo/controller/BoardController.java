package com.jooboard.joo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jooboard.joo.dao.BoardDao;
import com.jooboard.joo.service.BoardService;
import com.jooboard.joo.vo.BoardVO;
import com.jooboard.joo.vo.PageMaker;
import com.jooboard.joo.vo.PagingCriteria;
import com.jooboard.joo.vo.ReplyVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardDao bDao;
	
	@Autowired
	BoardService bSrvc;
	
	//게시판 리스트
	@RequestMapping("/boardList.joo") 
	public String board(Model model, PagingCriteria pCri, HttpSession session) {
		int total = bDao.getTotal(pCri);
		
		List<BoardVO> boardList = bDao.getSearchList(pCri);
		model.addAttribute("boardList", boardList);
		model.addAttribute("paging", new PageMaker(pCri, total));
		model.addAttribute("keyword", pCri.getKeyword());
		model.addAttribute("sDate", pCri.getsDate());
		model.addAttribute("eDate", pCri.geteDate());
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

	//댓글 가져오기
	@RequestMapping(value="/boardComment.joo", produces="application/json")
	@ResponseBody
	public List<BoardVO> getReplyList(ReplyVO rVO, int bno) {
		List<BoardVO> REPLY = bDao.getReplyList(bno);
		return REPLY;
	}
	
	//댓글 등록하기
	@RequestMapping("/addComment.joo")
	@ResponseBody
	public String addComment(ReplyVO rVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		try {
			rVO.setRwriter((String)session.getAttribute("SID"));
			bDao.addComment(rVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	//대댓글 등록하기
	@RequestMapping("/addReComment.joo")
	@ResponseBody
	public String addReComment(ReplyVO rVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		try {
			rVO.setRwriter((String)session.getAttribute("SID"));
			bDao.addReComment(rVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	//댓글 수정
	@RequestMapping("/editComment.joo")
	@ResponseBody
	public String editComment(ReplyVO rVO) {
		try {
			bDao.editComment(rVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	//댓글 삭제
	@RequestMapping("/delComment.joo")
	@ResponseBody
	public String delComment(int rno) {
		try {
			bDao.delComment(rno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
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





