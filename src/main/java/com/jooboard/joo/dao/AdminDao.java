package com.jooboard.joo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jooboard.joo.vo.*;

@Repository
public class AdminDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//멤버 리스트 조회
	public List<MemberVO> getMemberList(){
		return sqlSession.selectList("mSQL.getMemberList");
	}
}
