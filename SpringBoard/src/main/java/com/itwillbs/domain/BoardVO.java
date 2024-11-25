package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

/**
 * tbl_board 테이블의 정보를 모두 저장하는 객체 
 *  
 *
 */


//@Setter
//@Getter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class BoardVO {

	private int bno;
	private String title;
	private String content;
	private String writer;
	private String viewcnt;
	private Timestamp regdate;
}
