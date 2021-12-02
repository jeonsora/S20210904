package com.oracle.s20210904.gm.service;

import java.util.List;

import com.oracle.s20210904.comm.model.ComAnnounce;
import com.oracle.s20210904.comm.model.Comm;
import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.comm.model.Scrap;

public interface GmAnnoService {

	int total();

	List<ComAnnounce> listAnno(ComAnnounce comAnnounce);

	ComAnnounce detail(String anno_code);

	Comm recjob(ComAnnounce com);

	//Comm emptype();

	Comm emptype(ComAnnounce comanno);

	Comm Techtag1(ComAnnounce comanno);

	Comm Techtag2(ComAnnounce comanno);

	Comm career(ComAnnounce comanno);

	Comm comsec(ComAnnounce comanno);
	
	//Scrap scrap(String anno_code, String user_id);

	int likecnt(Scrap scrap);

	void likeinsert(Scrap scrap);

	int likegetinfo(Scrap scrap);

	void likeupdate(Scrap scrap);

	int applytotal();

	List<Resume> listres(Resume resume);

	Resume selResume(Resume resume);

	void likedelete(Scrap scrap);

	
	
	



}
