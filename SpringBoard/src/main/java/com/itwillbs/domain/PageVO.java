package com.itwillbs.domain;

/**
 *	페이지 블럭을 처리하기위한 정보를 저장하는 객체 
 * 
 *  한페이지에 출력수, 총 글의 개수, 페이지 블럭의 크기
 *	페이지, 블럭시작번호, 블럭끝번호, 다음, 이전
 *
 *
 */
public class PageVO {
	
	private int totalCount;			//총 글의 개수
	private int pageBlock = 10;			//페이지 블럭의 크기
		
	private int startPage;			// 블럭 시작번호
	private int endPage;			// 블럭 끝번호
	
	private boolean next;			// 다음버튼
	private boolean prev;			// 이전버튼
	
	private Criteria cri;
	//private int page;				// 페이지 번호
	//private int pageSize;			// 페이지 크기

	// alt shift s + r
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		System.out.println(" **** 페이지 블럭 정보 계산 시작 **** ");
		calcData();
		System.out.println(" **** 페이지 블럭 정보 계산 끝 **** ");
	}
	
	public void calcData() {
		
		// 페이징 블럭 끝번호
		endPage = (int)(Math.ceil(cri.getPage() / (double)pageBlock)) * pageBlock;
		
		// 페이징 블럭 시작번호
		startPage = (endPage - pageBlock) + 1;
		
		// 임시 끝번호
		int tmpEndPage 
		    = (int)(Math.ceil(((double)totalCount/cri.getPageSize())));
//		    totalCount/cri.getPageSize()
//		        + (totalCount%cri.getPageSize()== 0? 0:1);
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;			
		}
		
		// 이전
		//prev = startPage == 1? false:true;
		prev = startPage != 1;
		// 다음
		//next = endPage * cri.getPageSize() >= totalCount? false:true;
		next = endPage * cri.getPageSize() < totalCount;
		
	}
	///////////////////////////////////////////////////////////
	public int getTotalCount() {
		return totalCount;
	}

	

	public int getPageBlock() {
		return pageBlock;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public Criteria getCri() {
		return cri;
	}



	// alt shift s + s
	@Override
	public String toString() {
		return "PageVO [totalCount=" + totalCount + ", pageBlock=" + pageBlock + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", next=" + next + ", prev=" + prev + ", cri=" + cri + "]";
	}
	
	
}
