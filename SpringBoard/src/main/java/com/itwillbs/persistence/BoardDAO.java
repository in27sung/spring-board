package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

/**
 * 서비스 객체가 호출 할 메서드 정보
 *
 */
public interface BoardDAO {
	
	// 글쓰기 (DB이름 선호)
	public void insertBoard(BoardVO vo) throws Exception;
	
	// 글 목록조회
	public List<BoardVO> selectBoardListAll() throws Exception;
	
}
