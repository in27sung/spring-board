package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.PageVO;
import com.itwillbs.service.BoardService;

/**
 * 컨트롤러 생성시 고민해볼것 - 공통 URI주소 - 각 기능별 URI주소 (+처리방식 GET/POST) - 결과 처리페이지 & 리다이렉트
 * 동작 - 예외처리
 */

@Controller
@RequestMapping(value = "/board/*") // 공통 URI주소
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService bService;

	// http://localhost:8088/board/regist
	// 게시판 만들기(글 작성하기)
	// /board/regist (GET - 정보조회,정보입력,단순출력)
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void registGET() throws Exception {
		logger.info(" /board/regist 호출 ");
		logger.info(" 연결된 뷰페이지(/board/regist.jsp) 이동 ");
	}

	// 게시판 만들기(글 작성하기)
	// /board/regist (POST - 정보처리(생성,수정,삭제))
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPOST(BoardVO vo, RedirectAttributes rttr) throws Exception {
		logger.info(" /regist.jsp (submit 실행) ");

		// 전달정보 (파라메터) 저장
		logger.info(" vo: {}", vo);

		// 서비스 -> DAO -> mapper(sql 호출)
		bService.regist(vo);

		// 정보 전달
		rttr.addFlashAttribute("result", "registOK");

		// 페이지 이동(/board/listAll)
		//return "redirect:/board/listAll";
		// 페이지 이동(/board/listCri) 페이징처리
		return "redirect:/board/listCri";
	}

	// http://localhost:8088/board/listAll
	// 게시판 목록 (GET - /board/listAll)
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAllGET(Model model) throws Exception {

		logger.info(" /board/listAll 호출 ");

		// 서비스 -> DAO 호출 (작성된 게시판글 정보를 모두 가져오기)
		List<BoardVO> boardList = bService.getListAll();

		logger.info("글 : " + boardList.size() + "개");
		// view 페이지로 출력할 정보를 전달
		model.addAttribute("boardList", boardList);

		// /board/list.jsp 페이지로 이동
		return "/board/list";
	}

	// http://localhost:8088/board/listCri
	// http://localhost:8088/board/listCri?page=2
	// http://localhost:8088/board/listCri?page=2&pageSize=20
	// 게시판 목록 (GET - /board/listCri)
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public String listCriGET(Model model,Criteria cri) throws Exception {

		logger.info(" /board/listCri 호출 ");
//		Criteria cri = new Criteria();
//		cri.setPage(1);
//		cri.setPageSize(10);

		// 서비스 -> DAO 호출 (작성된 게시판글 정보를 모두 가져오기)
		List<BoardVO> boardList = bService.getListPage(cri);
		logger.info("글 : " + boardList.size() + "개");
		
		// 페이징처리 블럭 정보 계산
		PageVO pageVO = new PageVO();
		pageVO.setCri(cri);
		//pageVO.setTotalCount(28672); 
		pageVO.setTotalCount(bService.getTotalCount()); 
		//=> 페이지 블럭에 필요한 정보계산 완료
		
		// view 페이지로 출력할 정보를 전달
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageVO", pageVO);

		// /board/list.jsp 페이지로 이동
		return "/board/list";
	}

	// http://localhost:8088/board/read?bno=1

	// 게시판 본문보기(GET) (/board/read)
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void readGET(@RequestParam("bno") int bno,
			 			@ModelAttribute("cri") Criteria cri,
						Model model
	/* @ModelAttribute("bno") int bno */) throws Exception {
		logger.info(" readGET() 실행 ");

		// 전달받은 정보 저장(bno)
		logger.info(" bno : " + bno);

		// 서비스 -> DAO (동작: 게시판 글 조회수 1증가)
		// updateViewCnt()
		bService.updateViewCnt(bno);
		logger.info(" 글 조회수 1증가 완료!");

		// bno에 해당하는 글정보를 가져와서 출력
		// 서비스(getBoard()) -> DAO(selectBoard())
		BoardVO resultVO = bService.getBoard(bno);

		// 연결된 뷰페이지로 정보 출력(Model)
		model.addAttribute("resultVO", resultVO);

		logger.info(" /views/board/read.jsp 페이지 연결 ");
	}

	// http://localhost:8088/board/modify?bno=1
	// 게시판 글 수정하기 GET
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno,
						  @ModelAttribute("cri") Criteria cri,
						  Model model) throws Exception {
		logger.info(" modifyGET() 호출 ");
		// 전달정보(bno) 저장
		logger.info(" 수정 글번호 : " + bno);

		// 서비스 -> DAO : 특정 bno에 해당하는 글정보를 조회
		BoardVO resultVO = bService.getBoard(bno);
		// 연결된 뷰페이지(/board/modify.jsp) 전달(출력)

		// model.addAttribute(bService.getBoard(bno));
		model.addAttribute(resultVO);// => boardVO
		// model.addAttribute("resultVO",resultVO);// => resultVO

	}

	// 게시판 글 수정하기 POST
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo,
			 				 @ModelAttribute("cri") Criteria cri,
			                 RedirectAttributes rttr) throws Exception {
		logger.info(" modifyPOST() 호출 ");

		// 전달정보 저장(수정 정보-파라메터 bno,title,writer,content)
		logger.info(" vo : {}", vo);
		logger.info(" cri : {}", cri);

		// 서비스 -> DAO (전달받은 정보를 사용해서 데이터 수정update)
		// 특정bno에 해당하는 정보(title,writer,content) 수정
		bService.updateBoard(vo);
		logger.info(" 글정보 수정완료! ");

		// 정보(수정완료)를 listAll 페이지로 전달
		rttr.addFlashAttribute("result", "modifyOK");
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("pageSize", cri.getPageSize());		

		//return "redirect:/board/listAll";
		return "redirect:/board/listCri";
	}

	// http://localhost:8088/board/remove (POST)
	// 글 삭제
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removePOST(@RequestParam("bno") int bno,
							 @ModelAttribute("cri") Criteria cri,
							 RedirectAttributes rttr
			                 ) throws Exception {
		logger.info(" removePOST() 호출 ");

		// 전달받은 정보(bno)를 저장
		logger.info(" bno : " + bno);

		// 서비스 -> DAO (특정 bno의 글정보를 삭제)
		int result = bService.removeBoard(bno);
		// 삭제 처리 결과 O => 리스트 페이지로 이동
		if (result == 1) {
			
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("pageSize", cri.getPageSize());
			
			//return "redirect:/board/listAll";
			return "redirect:/board/listCri";
		}
		// 삭제 처리 결과 X => 다시 본문페이지로 이동

		return "redirect:/board/read?bno=" + bno;
	}

}// BoardController
