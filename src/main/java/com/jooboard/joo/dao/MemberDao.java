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
	public MemberVO doLogin(MemberVO mVO) {
		return sqlSession.selectOne("mSQL.login", mVO);
	}
	
	//사용자 추가
	public int insertMember(ArrayList<MemberVO> list) {
		return sqlSession.insert("mSQL.addMemb", list.get(0));
	}
}
