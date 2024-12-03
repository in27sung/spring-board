package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

/**
 *  서비스 객체가 호출 할 메서드 정보 
 *
 */
public interface BoardDAO {
	
	// 글쓰기
	public void insertBoard(BoardVO vo) throws Exception;
	
	// 글 목록조회
	public List<BoardVO> selectBoardListAll() throws Exception;
	
	// 글 조회수 1증가 
	public void updateReadCnt(int bno) throws Exception;
	
	// 특정 글정보를 조회
	public BoardVO selectBoard(int bno) throws Exception;
	
	// 글정보 수정
	public void updateBoard(BoardVO vo) throws Exception;
	
	// 글정보 삭제
	public int deleteBoard(Integer bno) throws Exception;
	
	// 글 목록조회(+페이징처리)
	public List<BoardVO> selectBoardListPage(int page) throws Exception;
	
	public List<BoardVO> selectBoardListCri(Criteria cri) throws Exception;

	// 글 전체 개수 조회
	public int selectTotalCount() throws Exception;

}
