package com.jooboard.joo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jooboard.joo.dao.AdminDao;
import com.jooboard.joo.vo.MemberVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminDao aDao;
	
	//사용자관리 페이지 진입
	@RequestMapping("/adminMember.joo")
	public String adminMember() {
		return "admin/adminMember";
	}
	
	//사용자관리
	@RequestMapping(value="/adminMemberList.joo", method= {RequestMethod.POST})
	@ResponseBody
	public List<MemberVO> adminMemberList(HttpServletRequest request) {
		List<MemberVO> mVO = aDao.getMemberList();
		return mVO;
	}

	//게시글관리
	@RequestMapping("/adminBoard.joo")
	public String adminBoard() {
		
		return "admin/adminBoard";
	}
	
	//멤버강제탈퇴
	@RequestMapping("/adminDelMemb")
	@ResponseBody
	public String delMemb(String valueArr) {
		JSONArray arr = new JSONArray(valueArr);
		int result = 0;
		try {
			for(int i = 0; i< arr.length(); i++) {
				result += aDao.delMemb(arr.getInt(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
		
	}
	
	//멤버권한변경
	@RequestMapping("/adminEditMemb.joo")
	@ResponseBody
	public String editMemb(@RequestParam(defaultValue = "") String authList) {
		int result = 0;
		try { 
				JSONArray authArr = new JSONArray(authList);
				System.out.println("%%%%%%%%%%%%%%%%"+authArr);
				for(int i=0; i< authArr.length(); i++) {
					String authStr = authArr.getString(i);
					String mno = authStr.split("_")[0];
					String auth = authStr.split("_")[1];
					
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("mno", mno);
					map.put("auth", auth);
					
					result += aDao.editMemb(map); 
				}
			} 
		catch (Exception e) {
				e.printStackTrace(); 
		}
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
			
		
	}
	
}
