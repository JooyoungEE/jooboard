package com.jooboard.joo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jooboard.joo.vo.*;

@Repository("testDAO")
public class TestDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//테스트용 회원 정보조회 전담 함수
	public MemberVO getInfo(MemberVO tno) {
		return (MemberVO)sqlSession.selectOne("tSQL.getTest", tno);
	}
}
