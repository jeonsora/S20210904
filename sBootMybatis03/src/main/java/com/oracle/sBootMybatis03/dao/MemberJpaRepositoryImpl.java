package com.oracle.sBootMybatis03.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.sBootMybatis03.domain.Member;

@Repository
public class MemberJpaRepositoryImpl implements MemberJpaRepository {

	private final EntityManager em;
	
	@Autowired
	public MemberJpaRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}


	@Override
	public List<Member> findAll() {
		System.out.println("MemberJpaRepositoryImpl findAll()");
		List<Member> memberList = em.createQuery("select m from member2 m", Member.class).getResultList();
		return memberList;
	}

}






















