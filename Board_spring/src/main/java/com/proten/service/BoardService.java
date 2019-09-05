package com.proten.service;

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

}
