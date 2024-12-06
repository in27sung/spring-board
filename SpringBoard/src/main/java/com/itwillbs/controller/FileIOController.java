package com.itwillbs.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.FileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileIOController {

	private static final Logger logger = LoggerFactory.getLogger(FileIOController.class);

	//http://localhost:8088/form
	// 파일업로드 시작페이지
	@RequestMapping(value = "/form",method = RequestMethod.GET)
	public void fileFormGET() throws Exception{
		logger.info("fileFormGET() 호출 ");		
		
	}
	
	
	
	// 파일업로드 처리
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public String fileUploadPOST(MultipartHttpServletRequest multi,
			                     Model model) throws Exception{
		
		logger.info(" fileUploadPOST() 실행!! ");
		// 전달정보 인코딩
		multi.setCharacterEncoding("UTF-8");
		
		// 업로드에 전달된 정보를 저장 객체
		Map map = new HashMap();
		
		// 1. 파라메터 정보 처리
		// 전달받은 파라메터 이름들만 저장(파일정보 제외)
		Enumeration enu = multi.getParameterNames();
		
		while(enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multi.getParameter(name);
			
			logger.info("name : "+name+", value : "+value);
			
			map.put(name, value);
		}
		
		logger.info(" map : {}",map);
		
		// 2. 파일 업로드 처리
		List<String> fileList = fileProcess(multi);
		map.put("fileList", fileList);
		
		logger.info(" map : {}",map);
		model.addAttribute("map", map);
		
		
		return "result";
	}// fileUploadPOST
	
	private List<String> fileProcess(MultipartHttpServletRequest multi) throws Exception{
		
		// 파일 업로드 & 파일 이름저장
		
		// 파일의 이름을 저장하는 리스트
		List<String> fileList = new ArrayList<String>();
		
		Iterator fileNames = multi.getFileNames();
		while(fileNames.hasNext()) {
			// 업로드되는 파일의 파라메터이름
			String fileName = (String)fileNames.next();
			logger.info("fileName : "+fileName);
			
			MultipartFile mFile = multi.getFile(fileName);
			String oFileName = mFile.getOriginalFilename();
			fileList.add(oFileName);
			
			//File file = new File("C:\\upload\\"+fileName);
			File file = new File("C:\\upload\\"+oFileName);
			if(mFile.getSize() != 0) { // 업로드된 파일의 정보가 있을때
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}					
				}
				mFile.transferTo(file);
			}	
			logger.info(" 파일 업로드 성공! ");
		}// while
		
		return fileList;
	}// fileProcess() 끝
	
	
	// 파일 다운로드
	@RequestMapping(value = "/download",method = RequestMethod.GET)
	public void fileDownloadGET(@RequestParam("fileName") String fileName,
			                    HttpServletResponse response) throws Exception{
		
		logger.info(" fileDownloadGET() 호출 ");
		
		OutputStream out = response.getOutputStream();
		
		// 다운로드할 파일 준비
		String downFile = "C:\\upload\\"+fileName;
		File file = new File(downFile);
		FileInputStream fis = new FileInputStream(file);
		
		
	}
	
	
	
	
}//class
