
/**
 * 실제 사용자가 수행할 동작을 추상메서드로 정의
 */
package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

public interface BoardService {
	
	// 글쓰기 
	public void regist(BoardVO vo) throws Exception;
	
	// 글목록(All)
	public List<BoardVO> getListAll() throws Exception; 
	
	// 글 조회수 1증가
	public void updateViewCnt(int bno) throws Exception;
	
	// 특정 글정보를 조회
	public BoardVO getBoard(int bno) throws Exception;
	
	// 글 정보를 수정
	public void updateBoard(BoardVO vo) throws Exception;
	
	// 글 삭제
	public int removeBoard(Integer bno) throws Exception;
	
	// 글 목록 조회(페이징처리)
	public List<BoardVO> getListPage(Criteria cri) throws Exception;
	
	// 글 전체 개수 조회
	public int getTotalCount() throws Exception;

}
