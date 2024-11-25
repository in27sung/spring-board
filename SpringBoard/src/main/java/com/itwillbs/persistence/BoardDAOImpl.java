package com.itwillbs.persistence;

import java.beans.Statement;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	private static final String NAMESPACE
						="com.itwillbs.mapper.BoardMapper.";
	
	// 디비연결 객체 주입 
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		
		logger.info("디비 접근해서 해당 SQL 실행");
		sqlSession.insert(NAMESPACE + "insertBoard", vo);
	}

	@Override
	public List<BoardVO> selectBoardListAll() throws Exception {
		
		logger.info("selectBoardListAll() 호출");
		logger.info("DAO -> mapper(sql) 실행");
		
		// mapper 호출 & 실행 
		List<BoardVO> boardList
		= sqlSession.selectList(NAMESPACE + "selectBoardListAll");
		
		
		return boardList;
	}
	
}
