package com.realEstate.www.common;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAO extends SqlSessionDaoSupport{
	
	@Autowired 
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory); 
	}
	
	private static final Logger logger = LoggerFactory.getLogger(CommonDAO.class);
	   
    private void printQueryId(String queryId) {
	    if(logger.isDebugEnabled()) {
	        logger.info("[QueryId] : " + queryId);
	    }
    }

	public <T> T selectOne(String statement) {
		printQueryId(statement);
		return getSqlSession().selectOne(statement);
	}

	public <T> T selectOne(String statement, Object parameter) {
		printQueryId(statement);
		return getSqlSession().selectOne(statement, parameter);
	}

	public <E> List<E> selectList(String statement, Object parameter) {
		printQueryId(statement);
		return getSqlSession().selectList(statement, parameter);
	}

	public <E> List<E> selectList(String statement) {
		printQueryId(statement);
		return getSqlSession().selectList(statement);
	}

	public int insert(String statement, Object parameter) {
		printQueryId(statement);
		return getSqlSession().insert(statement, parameter);
	}

	public int update(String statement, Object parameter) {
		printQueryId(statement);
		return getSqlSession().update(statement, parameter);
	}

	public int delete(String statement, Object parameter) {
		printQueryId(statement);
		return getSqlSession().delete(statement, parameter);
	}
	
}
