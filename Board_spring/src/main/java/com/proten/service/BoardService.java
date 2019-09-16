package com.proten.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proten.bean.BoardVO;
import com.proten.bean.PageVO;
import com.proten.bean.SearchBean;
import com.proten.dao.BoardDAO;

@Service 
public class BoardService implements BoardServiceInterface {
	
	@Autowired
	private BoardDAO dao;
	
	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public BoardVO view(int no) {
		return dao.view(no);
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);	
	}


	@Override
	public List<BoardVO> list(PageVO pvo) {
		return dao.list(pvo);
	}

	@Override
	public void delete(int no) {
		dao.delete(no);	
	}

	@Override
	public int count() {
		return dao.count();
	}

	@Override
	public List<BoardVO> listSearch(SearchBean sb) {
		
		return dao.listSearch(sb);
	}

}
