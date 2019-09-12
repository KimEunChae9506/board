package com.proten.dao;

import java.util.List;

import com.proten.bean.BoardVO;
import com.proten.bean.PageVO; 

public interface BoardDAOInterface {

	public BoardVO view(int no);
	
	public void insert(BoardVO vo);
	
	public void update(BoardVO vo);
	
	public void delete(int no);
	
	public List<BoardVO> list(PageVO pvo);
	
	public int count();
}
