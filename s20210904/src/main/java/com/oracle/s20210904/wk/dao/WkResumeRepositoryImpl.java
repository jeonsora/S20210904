package com.oracle.s20210904.wk.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.wk.model.WkResume;

import oracle.net.aso.r;

@Repository
public class WkResumeRepositoryImpl implements WkResumeRepository{
	
	private final EntityManager em;
	
	@Autowired
	public WkResumeRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}


	@Override
	public List<WkResume> resumeList(String mbid) {
		System.out.println("WkResumeRepositoryImpl resumeList()");
		@SuppressWarnings("unchecked")
		List<Object[]> object=em.createQuery("select r.res_title, c.comm_ctx" + 
											" from WkResume r" + 
											" inner join Comm c" + 
											" on r.res_sts=c.sub_cat" + 
											" where r.user_id = :user_id"+
											" and r.res_sts!='003'" + 
											" and c.main_cat='065'")
								.setParameter("user_id", mbid).getResultList();
		//r.res_title, r.res_date, r.rep_res, c.comm_ctx
//		@SuppressWarnings("unchecked")
//		List<WkResume> result=null;
		System.out.println("WkResumeRepositoryImpl resumeList() object : "+object.get(0));
//		
		for(Object o : object) {
			Resume r=(Resume)o;
			System.out.println("r.getRes_title() : "+o);
			
		}
		
		
//		System.out.println("WkResumeRepositoryImpl resumeList() result.size : "+result.get(0).getRes_title());
//		System.out.println("WkResumeRepositoryImpl resumeList() query : "+query.);
		return null;
	}

}
