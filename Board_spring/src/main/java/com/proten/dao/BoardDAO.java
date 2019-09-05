package com.proten.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proten.bean.BoardVO;

@Repository //현재 이 클래스가 DAO라는것을 스프링에게 알려주는 역할을 하는 어노테이션
public class BoardDAO implements BoardDAOInterface {

	
	@Autowired //root-context.xml에서 작성했던 코드에 빈(bean)
	private SqlSession sql;
	
	
	
	@Override
	public void insert(BoardVO vo) {
		sql.insert("mapper.insert", vo);//sql.insert는 자체 구문, mapper.insert는 id
		
	}

}
