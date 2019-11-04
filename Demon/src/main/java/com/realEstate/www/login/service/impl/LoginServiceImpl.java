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
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return commonDAO.insert("mapper.Login.singup", map);
	}

	@Override
	public List<Map> selectSingUpMember() {
		
		Map map = new HashMap();
		
		map.put("id", "a");
		
		System.out.println("!@@@@!@!@!@!@!");
		
		return commonDAO.selectList("mapper.Login.selectSingUpMember", map);
	}
	
 
	
	
}
