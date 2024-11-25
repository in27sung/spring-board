package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

/**
 * 
 * BoardService 인터페이스 객체를 구현한 객체 
 * => 정의한 추상메서드를 구현(오버라이딩)
 */
// 외부에서 서비스 동작을 호출할때 모든 동작 수행 가능해짐 
@Service
public class BoardServiceImpl implements BoardService{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Inject
	private BoardDAO bdao;
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		logger.info("글쓰기 실행");
		
		logger.info("DAO의 글쓰기 메서드 호출");
		bdao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getListAll() throws Exception {
		logger.info("getListAll() 호출");
		logger.info("서비스 -> DAO 메서드 호출");
		
		// DAO 메서드 호출 
		// BoardDAO bdao = new BoardDAO();
		List<BoardVO> boardList = bdao.selectBoardListAll();
		
		
		return boardList;
	}
	
	
}
