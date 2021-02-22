
package com.jooboard.joo.dao;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import com.jooboard.joo.util.PageUtil;
import com.jooboard.joo.vo.*;

@Repository
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//게시글 갯수 조회
	public int getTotal() {
		return sqlSession.selectOne("mSQL.getTotal");
	}
	
	//게시글 리스트 조회
	public List<BoardVO> getList(PagingCriteria paging){
		return sqlSession.selectList("mSQL.getList", paging);
	}
	
	//게시글 내용 조회
	public BoardVO getDetail(int bno) {
		return sqlSession.selectOne("mSQL.getDetail", bno);
	}
	
	// 게시글 수정 내용조회
	public List<Map> getEditDetail(int bno){
		return sqlSession.selectList("mSQL.getEditDetail", bno);
	}
	
	// 게시글 수정
	public int editBoard(BoardVO bVO) {
		return sqlSession.update("mSQL.editBoard", bVO);
	}
	
	//게시글 삭제
	public int delBoard(int bno) {
		return sqlSession.update("mSQL.delBoard", bno);
	}
	
	//게시글 작성
	public int writeBoard(BoardVO bVO) {
		return sqlSession.insert("mSQL.writeBoard", bVO);
	}
}

