package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	// 디비연결 객체 주입
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE
	                  ="com.itwillbs.mapper.BoardMapper.";
	
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		logger.info(" 디비 접근해서 해당 SQL 실행 ");		
		sqlSession.insert(NAMESPACE + "insertBoard", vo);
	}

	@Override
	public List<BoardVO> selectBoardListAll() throws Exception {
		logger.info(" selectBoardListAll() 호출 ");
		logger.info(" DAO -> mapper(sql) 실행");
		
		// mapper 호출 & 실행
		List<BoardVO> boardList 
		  = sqlSession.selectList(NAMESPACE + "getBoardListAll");
		
		return boardList;
	}

	@Override
	public void updateReadCnt(int bno) throws Exception {
		logger.info(" updateReadCnt(int bno) 실행 ");
		
		// mapper 접근 SQL 구문 실행
		sqlSession.update(NAMESPACE + "increaseViewCnt",bno);
		
		logger.info(" 조회수 1증가 완료! ");
		
	}

	@Override
	public BoardVO selectBoard(int bno) throws Exception {
		logger.info(" selectBoard(int bno) 실행 ");
		
		// mapper 접근 SQL 구문 실행
		return sqlSession.selectOne(NAMESPACE + "selectBoard",bno);
	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		logger.info("updateBoard(BoardVO vo) 호출 ");
		
		// mapper SQL 구문 호출
		sqlSession.update(NAMESPACE + "updateBoard",vo);
	}

	@Override
	public int deleteBoard(Integer bno) throws Exception {
		logger.info(" deleteBoard(Integer bno) 호출 ");
		
		return sqlSession.delete(NAMESPACE + "deleteBoard", bno);
	}

	@Override
	public List<BoardVO> selectBoardListPage(int page) throws Exception {
		logger.info(" selectBoardListPage() ");
		
		//페이지정보 1-0 / 2-10 / 3-20 / 4-30 / ....
		if(page <= 0)
			page = 1;
		
		page = (page - 1) * 10;
		
		return sqlSession.selectList(NAMESPACE + "listPage",page);
	}

	@Override
	public List<BoardVO> selectBoardListCri(Criteria cri) throws Exception {
		logger.info(" selectBoardListCri(Criteria cri) 호출 ");
		
		return sqlSession.selectList(NAMESPACE + "listCri",cri);
	}

	@Override
	public int selectTotalCount() throws Exception {
		logger.info(" selectTotalCount() 호출 ");
		
		return sqlSession.selectOne(NAMESPACE + "totalCount");
	}
	
	

}
