package com.oracle.sBootMybatis03.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@RequestMapping(value = "upLoadFormStart")
	public String upLoadFormStart() {
		System.out.println("UploadController upLoadFormStart()");
		
		return "upLoadFormStart";
	}
	
	@RequestMapping(value = "uploadForm", method=RequestMethod.POST)
	public String uploadForm(HttpServletRequest request,
							MultipartFile file1,
							Model model) throws IOException {
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
		System.out.println("UploadController uploadForm() origianlName : "+file1.getOriginalFilename());
		System.out.println("UploadController uploadForm() size : "+file1.getSize());
		System.out.println("UploadController uploadForm() contentType : "+file1.getContentType());
		System.out.println("UploadController uploadForm() uploadPath : "+uploadPath);
		String saveName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
		System.out.println("UploadController uploadForm() saveName : "+saveName);
		model.addAttribute("savedName", saveName);
		return "uploadResult";
	}
	
	private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws IOException {
		UUID uid=UUID.randomUUID();
//		requestPath = requestpath+"/resources/image";
		System.out.println("UploadController uploadFile() uploadPath : "+uploadPath);
//		Directory생성
		File fileDirectory=new File(uploadPath);
		if(!fileDirectory.exists()) {
			fileDirectory.mkdir();
			System.out.println("업로드용 폴더 생성 : "+uploadPath);
		}
		String saveName=uid.toString()+"_"+originalName;
		File target=new File(uploadPath, saveName);
		FileCopyUtils.copy(fileData, target); 	// org.springframework.util.FileCopyUtils
		
		return saveName;
	}
	
	@RequestMapping(value = "uploadFileDelete", method=RequestMethod.GET)
	public String uploadFileDelete(HttpServletRequest request, Model model) {
		String uploadPath=request.getSession().getServletContext().getRealPath("/upload/");
		String deleteFile=uploadPath+"bafcaa7c-ada4-4300-96c0-2ca2d2b604ab_table2.png";
		System.out.println("UploadController uploadFileDelete() deleteFile : "+deleteFile);
		int delResult=upFileDelete(deleteFile);
		model.addAttribute("deleteFile", deleteFile);
		model.addAttribute("delResult", delResult);
		
		return "uploadResult";
	}
	
	private int upFileDelete(String deleteFileName) {
		int result=0;
		System.out.println("UploadController upFileDelete()");
		File file=new File(deleteFileName);
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("삭제성공");
				result=1;
			}else {
				System.out.println("삭제실패");
			}
		}else {
			System.out.println("파일없음");
			result=-1;
		}
		return result;
	}
}



































