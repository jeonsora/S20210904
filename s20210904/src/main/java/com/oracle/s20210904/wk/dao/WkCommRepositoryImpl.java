package com.oracle.s20210904.wk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.Comm;
import com.oracle.s20210904.wk.model.WkCommDto;

@Repository
public class WkCommRepositoryImpl implements WkCommRepository{
	private final EntityManager em;
	
	@Autowired
	public WkCommRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public List<WkCommDto> commList(String main_cat) {
		System.out.println("WkCommRepositoryImpl commList()");
		List<WkCommDto> result=null;
		try {
			
//			TypedQuery<Comm> query =em.createQuery("select c from Comm c where c.main_cat = :main_cat", Comm.class)
//										.setParameter("main_cat", main_cat);
//			
//			result=query.getResultList();
					
			result=em.createQuery("select NEW com.oracle.s20210904.wk.model.WkCommDto(c.sub_cat, c.comm_ctx) "
						+ "from Comm c where c.main_cat = :main_cat and c.sub_cat!='999'", WkCommDto.class)
						.setParameter("main_cat", main_cat).getResultList();
//			Query query = em.createQuery("select NEW c.sub_cat, c.comm_ctx from Comm c where c.main_cat = :main_cat")
//					.setParameter("main_cat", main_cat);
			
			
		} catch (Exception e) {
			System.out.println("WkCommRepositoryImpl commList() error : "+e.getMessage());
		}
		
		return result;
	}
}
