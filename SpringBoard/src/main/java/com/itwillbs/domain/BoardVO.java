package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

/**
 *  tbl_board 테이블의 정보를 모두 저장하는 객체
 */
//@Data lombok사용 필요한 get/set메서드,생성자,toString()등 자동생성

@Data
public class BoardVO {
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private int viewcnt;
	private Timestamp regdate; 

}
