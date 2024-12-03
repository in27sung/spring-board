package com.itwillbs.domain;

/**
 *	페이징 처리에 필요한 정보를 저장하는 객체 
 *
 */
public class Criteria {
	
	private int page;		// 페이지 정보
	private int pageSize;	// 페이지 크기 정보
	
	public Criteria() {
		this.page = 1;
		this.pageSize = 10;
	}
	
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		
		//this.page = (page - 1) * 10;
		// => 특정 페이지에 따른 시작번호 계산
		this.page = page;
	}
	
	public void setPageSize(int pageSize) {
		if(pageSize <=0 || pageSize >100) {
			this.pageSize = 10;
			return;
		}
		this.pageSize = pageSize;
	}
	
	
	public int getPage() {
		return page;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	// 페이지 번호를 계산하는 메서드
	public int getStartPage() {
		
		return (this.page - 1) * pageSize;
	}
	

	// alt shift s + s
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
	
	
}
