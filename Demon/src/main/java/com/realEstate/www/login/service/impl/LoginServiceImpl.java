package com.realEstate.www.login.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realEstate.www.common.CommonDAO;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	CommonDAO commonDAO;
	
	@Override
	public int singup(Map map) {
		
		int cnt = commonDAO.selectOne("mapper.Login.selectCustoms", map);
		if(cnt == 0) {
			cnt = commonDAO.insert("mapper.Login.singup", map);
		}else {
			cnt = 0;
		}
		
		return cnt;
	}

	@Override
	public List<Map> selectSingUpMember() {
		
		Map map = new HashMap();

		return commonDAO.selectList("mapper.Login.selectSingUpMember", map);
	}

	@Override
	public int login(Map map) {
		return commonDAO.selectOne("mapper.Login.selectCustoms", map);
	}
	
 
	
	
}
