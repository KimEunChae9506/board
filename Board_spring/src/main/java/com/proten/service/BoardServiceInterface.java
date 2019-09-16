package com.proten.service;

import java.util.List;

import com.proten.bean.BoardVO;
import com.proten.bean.PageVO;
import com.proten.bean.SearchBean;

public interface BoardServiceInterface {

	public BoardVO view(int no);
	
	public void insert(BoardVO vo);
	
	public void update(BoardVO vo);
	
	public void delete(int no);
	
	public List<BoardVO> list(PageVO pvo);
	
	public int count();
	
	public List<BoardVO> listSearch(SearchBean sb);
}
