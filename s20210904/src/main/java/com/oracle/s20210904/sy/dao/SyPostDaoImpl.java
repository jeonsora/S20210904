package com.oracle.s20210904.sy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.Post;

@Repository
public class SyPostDaoImpl implements SyPostDao {
		@Autowired
		SqlSession session;

		@Override
		public void postInsert(Post post) {
		
		}

		@Override
		public void postUpdate(Post post) {
			
		}

		@Override
		public void postDelete(Post post) {
			
		}
}
