package com.itwillbs.controller;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DBConnectTest {
	
	@Inject
	private DataSource ds;
	//private Datasours ds = new () 
	// 객체의 강한 결합으로 인한 코드 수정 사항시 수정할 부분이 많으므로 
	// 인젝트 사용 
	
	@Inject 
	private SqlSessionFactory sqlFactory;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void DBConTest() {
		System.out.println(ds);
		System.out.println(sqlFactory);
		System.out.println(sqlSession);
	}
	
}
