package com.oracle.s20210904.ds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.s20210904.comm.model.Announce;
import com.oracle.s20210904.comm.model.Comm;
import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Post;
import com.oracle.s20210904.comm.model.Member;
import com.oracle.s20210904.ds.model.AnnounceCnt;
import com.oracle.s20210904.ds.model.DsComm;
import com.oracle.s20210904.ds.service.DsAdminService;
import com.oracle.s20210904.ds.service.Paging;

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
		// 직종별 공고갯수 가져오기
		List<AnnounceCnt> annCntList= dsAdminService.announceCnt();
		// 공고글 제목 가져오기
		List<Announce> announceList = dsAdminService.getAnnounce();
		int atotCnt = announceList.size();
		
		model.addAttribute("announceList",announceList);
		model.addAttribute("annCntList",annCntList);
		model.addAttribute("waitComList",waitComList);
		model.addAttribute("qnaList",qnaList);
		model.addAttribute("qtotCnt",qtotCnt);
		model.addAttribute("totCnt",totCnt);
		model.addAttribute("atotCnt",atotCnt);
		
		return "ds/AdminMain";
	}
	
	@GetMapping(value="memberMenu")
	public String memberMenu(Member member, Model model, String currentPage, String searchTxt) {
		
		int mtotCnt = dsAdminService.totCnt();
		System.out.println("mtotCnt->"+mtotCnt);
		
		Paging pg = new Paging(mtotCnt,currentPage);
		
		member.setStart(pg.getStart());   // 1
		member.setEnd(pg.getEnd());       // 10
		
		List<Member> userList = dsAdminService.getUserList(member);
		
		System.out.println("userList.size()->"+userList.size());

		
		model.addAttribute("mtotCnt",mtotCnt);
		model.addAttribute("userList",userList);
		model.addAttribute("pg",pg);
		return "ds/memberMenu";
	}
	
	@GetMapping(value="companyMenu")
	public String companyMenu(Company com, Model model, String currentPage, String currentPage2) {
		int ctotCnt = dsAdminService.ctotCnt();
		Paging pg = new Paging(ctotCnt,currentPage);
		com.setStart(pg.getStart());
		com.setEnd(pg.getEnd());
		List<Company> companyList = dsAdminService.getCompanyList(com);
		model.addAttribute("companyList",companyList);
		model.addAttribute("ctotCnt",ctotCnt);
		model.addAttribute("pg",pg);
		System.out.println("ctotCnt->"+ctotCnt);
		System.out.println("companyList->"+companyList.size());
		
		int cctotCnt = dsAdminService.cctotCnt();
		Paging pg2 = new Paging(cctotCnt,currentPage2);
		com.setStart(pg2.getStart());
		com.setEnd(pg2.getEnd());
		List<Company> companyConfirmList = dsAdminService.getComConfirmList(com);
		model.addAttribute("companyConfirmList",companyConfirmList);
		model.addAttribute("cctotCnt",cctotCnt);
		model.addAttribute("pg2",pg2);
		System.out.println("cctotCnt->"+cctotCnt);
		System.out.println("companyConfirmList->"+companyConfirmList.size());
		return "ds/companyMenu";
	}
	
	@GetMapping(value="boardMenu")
	public String boardMenu(Model model ,String currentPage, String currentPage2) {
		Post post = new Post();
		// Qna 리스트 페이징~
		int qtotCnt = dsAdminService.qtotCnt();
		Paging pg = new Paging(qtotCnt,currentPage);
		post.setStart(pg.getStart());
		post.setEnd(pg.getEnd());
		
		List<Post> qnaList = dsAdminService.getQnaList(post);
		model.addAttribute("qnaList",qnaList);
		model.addAttribute("pg",pg);
		model.addAttribute("qtotCnt",qtotCnt);
		
		// notice 리스트 페이징~
		int ntotCnt = dsAdminService.ntotCnt();
		Paging pg2 = new Paging(ntotCnt,currentPage2);
		post.setStart(pg2.getStart());
		post.setEnd(pg.getEnd());
		
		List<Post> noticeList = dsAdminService.getNoticeList(post);
		model.addAttribute("noticeList",noticeList);
		model.addAttribute("pg2",pg2);
		model.addAttribute("ntotCnt",ntotCnt);
		return "ds/boardMenu";
	}
	
	@GetMapping(value="tagMenu")
	public String tagMenu(DsComm dsComm,Model model, String currentPage) {
		int ttotCnt = dsAdminService.ttotCnt();
		Paging pg = new Paging(ttotCnt,currentPage);
		dsComm.setStart(pg.getStart());
		dsComm.setEnd(pg.getEnd());
		List<DsComm> dsCommList = dsAdminService.getDsCommList(dsComm);
		
		// modal 대분류
		List<Comm> mainCate = dsAdminService.getMainCate();
		model.addAttribute("mainCate",mainCate);
		
		model.addAttribute("dsCommList",dsCommList);
		model.addAttribute("ttotCnt",ttotCnt);
		model.addAttribute("pg",pg);
		
		return "ds/tagMenu";
	}
	

}
