package com.jooboard.joo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jooboard.joo.dao.*;
import com.jooboard.joo.vo.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminDao aDao;
	
	//사용자관리
	@RequestMapping("/adminMember.joo")
	@ResponseBody
	public ModelAndView adminMember(ModelAndView mv) {
		List<MemberVO> mVO = aDao.getMemberList();
		mv.addObject("memberList", mVO);
		mv.setViewName("admin/adminMember");
		return mv;
	}

	//게시글관리
	@RequestMapping("/adminBoard.joo")
	public String adminBoard() {
		
		return "admin/adminBoard";
	}
}
