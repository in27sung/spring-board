/**
 * 실제 사용자가 수행할 동작을 추상메서드로 정의 
 */

package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {
	
	// 글쓰기 
	public void regist(BoardVO vo) throws Exception; // try throws 강제성 
	
	// 글목록(All)
	public List<BoardVO> getListAll() throws Exception;
	
}
