package com.realEstate.www.login.service.impl;

import java.util.List;
import java.util.Map;

public interface LoginService {
	
	public int singup(Map map);
	public int login(Map map);
	
	public List<Map> selectSingUpMember();	
}
