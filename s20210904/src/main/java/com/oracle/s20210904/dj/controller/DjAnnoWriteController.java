package com.oracle.s20210904.dj.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210904.comm.model.Announce;
import com.oracle.s20210904.comm.model.Comm;
import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.dj.service.DjAnnoService;


@Controller
public class DjAnnoWriteController {
	// 데헷 공고 작성 컨트롤러 입니다
	
	@Autowired
	private DjAnnoService das;
	
	@RequestMapping("DjAnnoWriteForm")
	public String annoWriteForm(String com_id,Announce anno, Model model) {
		System.out.println("DjAnnoWriteController의 annoWrite 시작되었습니다.");
		
		com_id = "thsl90"; //공고 리스트와 잇기 전에 임시로 객체에 정보 넣기
		//회사 테이블에서 회사정보 가져오기 이것은 메뉴를 뿌려 줄 때 사용한다.
		Company compInfo = das.comInfoList(com_id);
		System.out.println("여기는 컨트롤러 회사정보 가져왔니? 회사명은?->"+compInfo.getCom_id());
		//-----------------------------------------
		//직종과 기술스택 가져오기 방법1 (가장 원시적인 방법 - 따로 가져오기)
//		List<Comm> jobTech1 = das.mainCatList1();
//		System.out.println("(컨트롤러)리스트 내용물 확인001->"+jobTech1.size());
//		List<Comm> jobTech2 = das.mainCatList2();
//		System.out.println("(컨트롤러)리스트 내용물 확인001->"+jobTech2.size());
		
		
//		List<Comm> jobTech1 = null; 
//		List<Comm> jobTech2 = null;
		
		
		List<Comm> jobTech12 = das.mainCatList();
		System.out.println("(컨트롤러)리스트 jobTech12에는 무엇이 들었나? ->"+jobTech12.size());
		
		
//		jobTech1 = list.stream().filter(jobTech12 -> "001".equals(jobTech12.getMain_cat())).collect(Collectors.toList());
//		jobTech2 = List.stream().filter(e -> "002".equals(e.getMain_cat())).collect(Collectors.toList());
		
	
		
			  //직종과 기술스택 가져오기 방법2 (list 하나로 갖고와서 향상된 forloop 혹은 while loop으로 나누기 - 제대로 작동이 안됨)

//        String getMain_cat = "";
//        String compStr001 = "001";
//			//향상된 FOR LOOP 이용
//		 for(Comm comm : jobTech12) {
//			 System.out.println("for comm.getMain_cat()->"+comm.getMain_cat());
//			 System.out.println("for comm.getSub_cat()->"+comm.getSub_cat());	
//			 System.out.println("for comm.getComm_ctx()->"+comm.getComm_ctx());
//			 System.out.println("---------------------");
//			 getMain_cat = comm.getMain_cat();
//			 System.out.println("for getMain_cat->"+getMain_cat);
//			 
//			  if(getMain_cat == "001"){
//					 System.out.println("001 comm.getSub_cat()->"+comm.getSub_cat());
//					 System.out.println("001 comm.getComm_ctx()->"+comm.getComm_ctx());
//					 jobTech1.add(comm); 
//			 
//			  } else if(getMain_cat == "002"){
//					 System.out.println("002 comm.getSub_cat()->"+comm.getSub_cat());
//					 System.out.println("002 comm.getComm_ctx()->"+comm.getComm_ctx());
//					 jobTech2.add(comm);
//			 }
		
			 // switch 이용 
				 
//				 switch(getMain_cat) {
//				 
//				 case "001": 
//					 jobTech1.add(comm); 
//					 break;
//				 case "002": 
//					 jobTech2.add(comm); 
//					 break;
//				 default : 
//					 System.out.println("뭔가 잘못됐는데?");
//					 break;
//				 
//				 }
//			}
		
		//3. 가장 진보된 방법 - 람다식 사용 
		  Map<Boolean, List<Comm>> jobTechTotal = jobTech12.stream()
			        .collect(Collectors.groupingBy(e -> "001".equals(e.getMain_cat())));

			    List<Comm> jobTech1 = jobTechTotal.get(true);
			    List<Comm> middlecont = jobTechTotal.get(false);
		//리스트를 맵 객체로 만든다? 받은 객체를 일단 게터를 이용해서 대분류가 001 이라는 문자를 갖고있는지 확인해서 분류한다.
		//아랫줄에서  Map<진위여부,리스트객체> 이렇게 있을 것이다. 
		//진위여부에 true를 입력하면 001로 분류된 것들이 jobTech1로 모이고 아니면 2로 모인다. 
			        
		  Map<Boolean, List<Comm>> middlecont1 = middlecont.stream()
				        .collect(Collectors.groupingBy(e -> "002".equals(e.getMain_cat())));

				    List<Comm> jobTech2 = middlecont1.get(true);
				    List<Comm> recEdu = middlecont1.get(false);	  
		//3가지를 받은 뒤에 1차 거르고 2차 거르는 형태인데.. 이거 switch문 같이 한번에 해결할 방법이 분명 있을 것 같다		    
			    
			    
		 System.out.println("jobTech1의 길이"+jobTech1.size());
		 System.out.println("jobTech2의 길이"+jobTech2.size());
		 System.out.println("recEdu의 길이"+recEdu.size());


		
		model.addAttribute("compInfo", compInfo);
		model.addAttribute("jobTech1", jobTech1);
		model.addAttribute("jobTech2", jobTech2);
		model.addAttribute("recEdu", recEdu);
	
		
		return "dj/annoWrite";
	}
	
	
	@PostMapping(value="DjAnnoWriting")
	public String annoWriting(Model model,Company comp, Announce anno) {
		System.out.println("컨트롤러에서 annoWriting 시작되었습니다. ");
		
		System.out.println("anno.getCom_id()->"+anno.getCom_id());
		System.out.println("anno.getCom_bus()->"+anno.getCom_bus());
		System.out.println("anno.getRec_vol()->"+anno.getRec_vol());
		System.out.println("anno.getRec_dtl()->"+anno.getRec_dtl());
		System.out.println("anno.getEmp_type()->"+anno.getEmp_type());
		System.out.println("anno.getCareer()->"+anno.getCareer());
		System.out.println("anno.getRec_edu()->"+anno.getRec_edu());
		System.out.println("anno.getPay_info()->"+anno.getPay_info());
		System.out.println("anno.getWork_cdt()->"+anno.getWork_cdt());
		System.out.println("anno.getEtc_cdt()->"+anno.getEtc_cdt());
		System.out.println("anno.getJob_tag()->"+anno.getJob_tag());
		System.out.println("anno.getTech_tag1()->"+anno.getTech_tag1());
		System.out.println("anno.getTech_tag2()->"+anno.getTech_tag2());
		System.out.println("anno.getAnno_regdate()->"+anno.getAnno_regdate());
		System.out.println("anno.getAnno_c_regdate()->"+anno.getAnno_c_regdate());
		System.out.println("anno.getAnno_title()->"+anno.getAnno_title());
		
		// 1. 공고 작성 사항 입력하기
		das.annoWriting(anno);
		
		
//		return "redirect:GmAnnoLIst";
		return "dj/testpage112";
	}
	
}
