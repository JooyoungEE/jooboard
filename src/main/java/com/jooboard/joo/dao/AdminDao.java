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
	
	//��� ����Ʈ ��ȸ
	public List<MemberVO> getMemberList(){
		return sqlSession.selectList("mSQL.getMemberList");
	}
	//��� ���� Ż��
	public int delMemb(int mno) {
		return sqlSession.delete("mSQL.delMemb", mno);
	}
	//��� ���� ����
	public int editMemb(HashMap<String, Object> map) {
		return sqlSession.update("mSQL.editMemb", map);
	}
}