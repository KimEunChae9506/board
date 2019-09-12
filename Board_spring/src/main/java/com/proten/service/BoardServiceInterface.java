package com.proten.service;

import java.util.List;

import com.proten.bean.BoardVO;

public interface BoardServiceInterface {

	public BoardVO view(int no);
	
	public void insert(BoardVO vo);
	
	public void update(BoardVO vo);
	
	public void delete(int no);
	
	public List<BoardVO> selcet();
	
	public int count();
}
