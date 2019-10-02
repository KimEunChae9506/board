package com.proten.service;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proten.bean.BoardVO;
import com.proten.bean.PageVO;
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
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", vo.toString());
		System.out.println(map);
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
	public int count(PageVO pvo) {
		return dao.count(pvo);
	}




	

}
