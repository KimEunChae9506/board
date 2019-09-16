package com.proten.dao;

import java.util.List;

import com.proten.bean.BoardVO;
import com.proten.bean.PageVO;
import com.proten.bean.SearchBean; 

public interface BoardDAOInterface {

	public BoardVO view(int no);
	
	public void insert(BoardVO vo);
	
	public void update(BoardVO vo);
	
	public void delete(int no);
	
	public List<BoardVO> list(PageVO pvo);//List<BoardVO> = resuleType
	
	public int count();
	
	public List<BoardVO> listSearch(SearchBean sb);
}
