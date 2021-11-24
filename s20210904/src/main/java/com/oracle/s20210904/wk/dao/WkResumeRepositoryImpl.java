package com.oracle.s20210904.wk.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.Resume;

@Repository
public class WkResumeRepositoryImpl implements WkResumeRepository{
	
	private final EntityManager em;
	
	@Autowired
	public WkResumeRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}


	@Override
	public List<Resume> resumeList(String mbid) {
		System.out.println("WkResumeRepositoryImpl resumeList()");
		Query query=em.createQuery("select r.res_title, r.res_date, r.rep_res, c.comm_ctx as res_sts" + 
											" from Resume r" + 
											" inner join Comm c" + 
											" on r.res_sts=c.sub_cat" + 
											" where r.user_id = :user_id"+
											" and r.res_sts!='003'" + 
											" and c.main_cat='065'", Resume.class)
								.setParameter("user_id", mbid);
	 
		@SuppressWarnings("unchecked")
		List<Resume> result=query.getResultList();
		
		/*
		 * List<Resume> result=em.
		 * createQuery("select res_title, res_date, rep_res, c.comm_ctx as res_sts" +
		 * " from Resume r" + " inner join Comm c" + " on r.res_sts=c.sub_cat" +
		 * " where user_id="+mbid+ " and res_sts!='003'" + " and c.main_cat='065'",
		 * Resume.class).getResultList();
		 */
		System.out.println("WkResumeRepositoryImpl resumeList() result.size : "+result.get(0).getRes_date());
//		System.out.println("WkResumeRepositoryImpl resumeList() query : "+query.);
		return result;
	}

}
