package com.jooboard.joo.dao;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.jooboard.joo.vo.*;
public class TestDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//테스트용 회원 정보조회 전담 함수
	public MemberVO getInfo(int tno) {
		return sqlSession.selectOne("tSQL.getTest", tno);
	}
}
