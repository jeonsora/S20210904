package com.oracle.sBootMybatis03.dao;

import java.util.List;

import com.oracle.sBootMybatis03.domain.Member;

public interface MemberJpaRepository {
	List<Member> findAll();
}
