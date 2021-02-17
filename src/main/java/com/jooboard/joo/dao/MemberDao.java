package com.jooboard.joo.dao;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.jooboard.joo.vo.MemberVO;

@Repository
public class MemberDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//로그인
	public int loginCnt(MemberVO mVO) {
		return sqlSession.selectOne("mSQL.login", mVO);
	}
	
//	//회원가입
//	public int insertMember(MemberVO mVO) {
//		return sqlSession.insert("mSQL.addMemb", mVO);
//	}

	public int insertMember(ArrayList<MemberVO> list) {
		System.out.println("★★★★★★★: "+list.get(0).getId());
		return sqlSession.insert("mSQL.addMemb", list);
	}
}
