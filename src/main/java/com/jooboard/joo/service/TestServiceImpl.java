package com.jooboard.joo.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jooboard.joo.dao.TestDao;
import com.jooboard.joo.vo.MemberVO;

@Service("testService")
public class TestServiceImpl implements TestService{

	private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);
     
    @Resource(name="testDAO")
    private TestDao testDAO;
    
    
    @Override
	public MemberVO selectTest(MemberVO memberVO) throws Exception {
    	9
		return testDAO.getInfo(memberVO);
    }
}
