package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

/**
 * 컨트롤러 생성시 고민해볼것 
 * - 공통 URI주소를 작성 
 * - 각 기능별 URI주소 (+처리방식 GET/POST) 
 * - 결과 처리 페이지 & 리다이렉트 동작 
 * - 예외처리 
 */


@Controller
@RequestMapping(value = "/board/*") // 공통 URI주소
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService bService;
	
	// 게시판 만들기(글 작성하기)
	// /board/regist (GET - 정보조회, 정보입력, 단순출력)
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void registGET() throws Exception {
		logger.info("/board/regist 호출");
		logger.info("연결된 뷰페이지(jsp) 이동");
		
	}
	// 게시판 만들기(글 작성하기)
	// /board/regist (POST - 정보처리(생성, 수정, 삭제))
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPOST(BoardVO vo) throws Exception {
		logger.info("/board/regist 호출");
		
		// 전달정보 (파라메터) 저장 
		logger.info("vo: {}", vo);
		// 서비스 -> DAO -> mapper(sql 호출)
		bService.regist(vo);
		// 페이지 이동(/board/listAll)
		return "redirect:/board/listAll";
	}
	
	// http://localhost:8088/board/listAll
	// 게시판 목록 (GET - /board/listAll)
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAllGET(Model model) throws Exception {
		logger.info("/board/listAllGET 호출");
		
		// 서비스 -> DAO 호출 (작성된 게시판글 정보를 모두 가져오기)
		List<BoardVO> boardList = bService.getListAll();
		
		logger.info("글: " + boardList.size() + "개");
		
		// view 페이지로 출력할 정보를 전달 
		model.addAttribute("boardList", boardList);
		
		logger.info("연결된 뷰페이지(jsp) 이동");
		// board/list.jsp 페이지 이동
		return "/board/list";
	}
	
	// 게시판 목록 (POST - /board/listAll)
	@RequestMapping(value = "/listAll", method = RequestMethod.POST)
	public void listAllPOST() throws Exception {
		logger.info("/board/listAllGET 호출");
		
		logger.info("연결된 뷰페이지(jsp) 이동");
		
	}
}// BoardController 
