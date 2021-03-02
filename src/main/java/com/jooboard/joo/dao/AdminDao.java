package com.jooboard.joo.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jooboard.joo.vo.MemberVO;

@Repository
public class AdminDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//¸â¹ö ¸®½ºÆ® Á¶È¸
	public List<MemberVO> getMemberList(){
		return sqlSession.selectList("mSQL.getMemberList");
	}
	//¸â¹ö °­Á¦ Å»Åð
	public int delMemb(int mno) {
		return sqlSession.delete("mSQL.delMemb", mno);
	}
	//¸â¹ö ±ÇÇÑ ¼öÁ¤
	public int editMemb(HashMap<String, Object> map) {
		return sqlSession.update("mSQL.editMemb", map);
	}
}