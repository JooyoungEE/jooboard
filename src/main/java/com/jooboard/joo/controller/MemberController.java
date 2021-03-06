package com.jooboard.joo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.view.*;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;
import com.jooboard.joo.dao.MemberDao;
import com.jooboard.joo.vo.MemberVO;
import com.jooboard.joo.util.*;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberDao mDao;
	
	@RequestMapping("/login.joo") 
	public String loginPage() {
		return "member/login";
	}
	
	@RequestMapping(path="/loginProc.joo", params={"id", "pw" }, method=RequestMethod.POST)
	public ModelAndView loginProc(ModelAndView mv, RedirectView rd,	HttpSession session, MemberVO mVO) {
		String userPW = Security.encrypt(mVO.getPw());
		mVO.setPw(userPW);
		
		MemberVO mem = mDao.doLogin(mVO);
		if(mem == null) {
			rd.setUrl("/member/login.joo");
		} else {
			session.setAttribute("SID", mem.getId());
			session.setAttribute("SAUTH", mem.getAuth());
			rd.setUrl("/main.joo");
		}
		
		mv.setView(rd);
		return mv;
	}
	
	@RequestMapping("/logout.joo")
	public ModelAndView logout(ModelAndView mv, HttpSession session) {
		String sid = (String)session.getAttribute("SID");
		session.removeAttribute("SID");
		
		mv.setViewName("redirect:/main.joo");
		return mv;
	}
	
	@RequestMapping("/join.joo") 
	public String joinPage() {
		return "member/join";
	}
	
	@RequestMapping(value="/joinProc.joo")
	@ResponseBody
	public ModelAndView joinProc(ModelAndView mv, HttpSession session, MemberVO mVO) {
		String result = "OK";
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		String userPW = Security.encrypt(mVO.getPw());
		mVO.setPw(userPW);
		
		list.add(mVO);
		int cnt = 0 ;
		try {
			cnt = mDao.insertMember(list);
		} catch(Exception e) {
			cnt = 0 ;
		}
		
		if(cnt == 1) {
			session.setAttribute("SID", mVO.getId());
			mv.setViewName("redirect:/main.joo");

		} else {
			result = "NO";
			mv.setViewName("redirect:/member/join.joo");
		}
		return mv;
		
	}
}
