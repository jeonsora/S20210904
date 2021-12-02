package com.oracle.s20210904.gm.dao;

import java.util.List;

import com.oracle.s20210904.comm.model.ComAnnounce;
import com.oracle.s20210904.comm.model.Comm;
import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.comm.model.Scrap;

public interface GmAnnoDao {

	int total();

	List<ComAnnounce> listAnno(ComAnnounce comAnnounce);

	ComAnnounce detail(String anno_code);

	//List<Comm> recjob();

	Comm recjob(ComAnnounce com);

	Comm emptype(ComAnnounce com);

	Comm Techtag1(ComAnnounce comanno);

	Comm Techtag2(ComAnnounce comanno);

	Comm career(ComAnnounce comanno);

	Comm comsec(ComAnnounce comanno);

	int likecnt(Scrap scrap);

	void likeinsert(Scrap scrap);

	int likegetinfo(Scrap scrap);

	void likeupdate(Scrap scrap);

	int applytotal();

	List<Resume> listres(Resume resume);

	Resume selResume(Resume resume);

	void likedelete(Scrap scrap);


	
	

	

}
