package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.BoardDAO;

/**
 * BoardService 인터페이스 객체를 구현한 객체 => 정의한 추상메서드를 구현(오버라이딩)
 */
@Service
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Inject
	private BoardDAO bdao;

	@Override
	public void regist(BoardVO vo) throws Exception {
		logger.info(" 글쓰기 실행 ");

		logger.info(" DAO의 글쓰기 메서드 호출 ");
		bdao.insertBoard(vo);
	}

	// alt shift s + v
	@Override
	public List<BoardVO> getListAll() throws Exception {
		logger.info(" getListAll() 호출 ");
		logger.info(" 서비스 -> DAO 메서드 호출 ");

		// DAO 메서드호출
		// BoardDAO bdao = new BoardDAO();
		List<BoardVO> boardList = bdao.selectBoardListAll();

		return boardList;
	}

	
	@Override
	public void updateViewCnt(int bno) throws Exception {
		logger.info(" updateViewCnt(int bno) 실행 ");
		// DAO 동작 호출
		bdao.updateReadCnt(bno);
		logger.info(" 글 조회수 1증가 ");
	}

	@Override
	public BoardVO getBoard(int bno) throws Exception {

		logger.info(" getBoard(int bno) 실행 ! ");

//		BoardVO vo =  bdao.selectBoard(bno);
//		return vo;
		
		// DAO 객체 호출
		return bdao.selectBoard(bno);
	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		 logger.info(" updateBoard(BoardVO vo) 호출 ");
		 
		 bdao.updateBoard(vo);
	}

	@Override
	public int removeBoard(Integer bno) throws Exception {
		logger.info(" removeBoard(Integer bno) 호출 ");
		return bdao.deleteBoard(bno);
	}

	@Override
	public List<BoardVO> getListPage(Criteria cri) throws Exception {
		logger.info(" getListPage(Criteria cri) ");
		
		return bdao.selectBoardListCri(cri);
	}

	@Override
	public int getTotalCount() throws Exception {
		logger.info(" getTotalCount() 호출 ");
		return bdao.selectTotalCount();
	}
	
	
	
	
	
	
	
	
}
