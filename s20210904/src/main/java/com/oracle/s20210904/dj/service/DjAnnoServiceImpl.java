package com.oracle.s20210904.dj.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210904.comm.model.Announce;
import com.oracle.s20210904.comm.model.Comm;
import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.dj.domain.DjAnnoDao;

@Service
public class DjAnnoServiceImpl implements DjAnnoService {

@Autowired
private DjAnnoDao dad;

@Override
public Company comInfoList(String com_id) {
	System.out.println("DjAnnoServiceImpl의 annoList1 시작되었습니다. ");
	Company comp1 = dad.comInfoList(com_id);
	
	System.out.println("comp1안에 뭔가 들어있니? 회사명?->"+comp1.getCom_id());
	
	
	return comp1;
}

@Override
public List<Comm> mainCatList1() {
	System.out.println("DjAnnoServiceImpl의 mainCatList1 시작되었습니다.");
	
	List<Comm> mainCat001 = dad.mainCatList1();
	System.out.println("(서비스)리스트 mainCat001에는 무엇이 들었나? ->"+mainCat001.size());
	
	return mainCat001;
}

@Override
public List<Comm> mainCatList2() {
	System.out.println("DjAnnoServiceImpl의 mainCatList2 시작되었습니다.");
	
	List<Comm> mainCat002 = dad.mainCatList2();
	System.out.println("(서비스)리스트 mainCat002에는 무엇이 들었나? ->"+mainCat002.size());
	
	return mainCat002;
}

@Override
public List<Comm> mainCatList() {
System.out.println("DjAnnoServiceImpl의 mainCatList 시작되었습니다.");
	
	List<Comm> mainCat = dad.mainCatList();
	System.out.println("(서비스)리스트 mainCat에는 무엇이 들었나? ->"+mainCat.size());
	
	return mainCat;
}

@Override
public void annoWriting(Announce anno) {
	System.out.println("DjAnnoServiceImpl의 annoWriting 시작했습니다.");
	
	dad.annoWriting(anno);
	
}


	
}
