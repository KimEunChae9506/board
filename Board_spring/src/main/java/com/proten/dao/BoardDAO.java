package com.proten.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proten.bean.BoardVO;
import com.proten.bean.PageVO;
@Repository //현재 이 클래스가 DAO라는것을 스프링에게 알려주는 역할을 하는 어노테이션
public class BoardDAO implements BoardDAOInterface {

	
	@Autowired //root-context.xml에서 작성했던 코드에 빈(bean)
	private SqlSession sql;

	@Override
	public void insert(BoardVO vo) {
		sql.insert("mapper.insert", vo);
		
	}

	@Override
	public void update(BoardVO vo) {
		sql.update("mapper.update", vo);
		
	}

	@Override
	public List<BoardVO> list(PageVO pvo) {
		
		return sql.selectList("mapper.list", pvo);
	}

	@Override
	public BoardVO view(int no) {
	
		return sql.selectOne("mapper.view", no);
	}


	@Override
	public void delete(int no) {
		sql.update("mapper.delete", no);
		
	}

	@Override
	public int count(PageVO pvo) {
		return sql.selectOne("mapper.count",pvo);
	}

	

}
