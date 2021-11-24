package com.oracle.s20210904.ds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Post;
import com.oracle.s20210904.ds.model.AnnounceCnt;
import com.oracle.s20210904.ds.service.DsAdminService;

@Controller
public class DsAdminController {
	
	@Autowired
	DsAdminService dsAdminService;
	
	@GetMapping(value="AdminMain")
	public String AdminMain(Model model) {
		// 가입승인 대기중인놈들 가져옵니다
		List<Company> waitComList = dsAdminService.getWaitCompany(); 
		int totCnt = waitComList.size();
		// QnA게시판 목록 가져옵니다.
		List<Post> qnaList = dsAdminService.getQnaList();
		int qtotCnt = qnaList.size();
		// 직종별 공고갯수
		List<AnnounceCnt> annCntList= dsAdminService.announceCnt();
		
		
		model.addAttribute("annCntList",annCntList);
		model.addAttribute("waitComList",waitComList);
		model.addAttribute("qnaList",qnaList);
		model.addAttribute("qtotCnt",qtotCnt);
		model.addAttribute("totCnt",totCnt);
		
		return "ds/AdminMain";
	}

}
