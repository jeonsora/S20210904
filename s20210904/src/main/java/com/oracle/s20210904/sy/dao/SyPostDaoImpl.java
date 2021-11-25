package com.oracle.s20210904.sy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.Post;

@Repository
public class SyPostDaoImpl implements SyPostDao {
		@Autowired
		SqlSession session;
		
		// 게시글 목록
		@Override
		public List<Post> postList(Post post) throws Exception {
			return SqlSession.postList("post.postList");
			
		}
		
		// 게시글 작성
		@Override
		public void postInsert(Post post) throws Exception {
			SqlSession.postInsert("post.postInsert", post);
		
		}
		
		// 게시글 수정
		@Override
		public void postUpdate(Post post) throws Exception {
			SqlSession.postUpdate("post.postUpdate", post);
		}
		
		// 게시글 삭제
		@Override
		public void postDelete(int post_code) throws Exception {
			SqlSession.delete("post.postDelete", post_code);
		}
		
		// 작성글 조회
		@Override
		public Post postRead(int post_code) throws Exception {
			return null;
		}
		// 게시글 조회수
		@Override
		public void increasePostView(int post_code) throws Exception {
			
		}

}
