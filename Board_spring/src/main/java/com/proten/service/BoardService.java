package com.proten.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proten.bean.BoardVO;
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
		// TODO Auto-generated method stub
		return dao.view(no);
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
		
	}


	@Override
	public List<BoardVO> selcet() {
		// TODO Auto-generated method stub
		return dao.selcet();
	}

	@Override
	public void delete(int no) {
		dao.delete(no);
		
	}

	@Override
	public int count() {
		return dao.count();
	}

}
