package com.oracle.s20210904.sy.dao;

import java.util.List;

import com.oracle.s20210904.comm.model.Post;

public interface SyPostDao {
	
	// 게시글 목록
	public List<Post> postList(Post post) throws Exception;
	
	// 게시글 작성
	public void postInsert (Post post) throws Exception;
	
	// 작성글 조회
	public Post postRead(int postCode) throws Exception;
	
	// 게시글 수정
	public void postUpdate (Post post) throws Exception;
	
	// 게시글 삭제
	void postDelete (int postCode) throws Exception;
	
	// 게시글 조회수
	public void increasePostView (int postCode) throws Exception;
}
