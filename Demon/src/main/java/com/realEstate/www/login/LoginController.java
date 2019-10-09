package com.realEstate.www.login;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/login") 
public class LoginController {
	
	//특정 글번호에 대한 코멘트 전체 목록 가져오기
	@ResponseBody
	@RequestMapping(value="/customsLogin",produces="text/html; charset=UTF-8", method = RequestMethod.POST)
	public String getSearchList(@RequestParam Map<String, String> map) throws Exception{
				
		System.out.println(map.get("customsId").toString());
		System.out.println(map.get("customsPwd").toString());
		
		List<Map> comments= new ArrayList<Map>();
		
		map.put("data1", "1");
		map.put("data2", "2");
		
		comments.add(map);
		
		return JSONArray.toJSONString(comments);
	}
	
	//특정 글번호에 대한 코멘트 전체 목록 가져오기
	@ResponseBody
	@RequestMapping(value="/singUp",produces="text/html; charset=UTF-8", method = RequestMethod.POST)
	public String singUp(@RequestParam MultipartHttpServletRequest request) throws Exception{
		
		System.out.println(request.getAttribute("name"));
		
		System.out.println(request.getParameter("id"));
		
		request.getAttribute("name");
		
		List a = new ArrayList();
		
		
		
		return JSONArray.toJSONString(a);
	}
	
	//생년월일에 사용할 날짜 얻
	@ResponseBody
	@RequestMapping(value="/getDate",produces="text/html; charset=UTF-8", method = RequestMethod.POST)
	public String getDate(@RequestParam Map map) throws Exception{
		
		Map<String, String> date = new HashMap<String, String>();
		
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy");
		
	    Calendar calendar = Calendar.getInstance();
		
		Date time = new Date();
				
		int year = Integer.valueOf(format.format(time));
		
		calendar.set(year, 1, 1);
		
		List<Integer> years = new ArrayList<Integer>();
		List<Integer> months = new ArrayList<Integer>();
		List<Integer> days = new ArrayList<Integer>();
		
		
		StringBuffer y = new StringBuffer();
		StringBuffer m = new StringBuffer();
		StringBuffer d = new StringBuffer();
		StringBuffer c = new StringBuffer();
		
		for(int i = 0 ; i < 100  ; i++) {
			y.append("<option value='"+year+"' >"+year+"</option>");
			year--;
		}
		int mt = 1;
		for(int i = 0 ; i < 12 ; i++) {
			m.append("<option value='"+mt+"' >"+mt+"</option>");
			mt++;
		}
		int day = 1;
		int dayMax = calendar.getMaximum(Calendar.DAY_OF_MONTH);
		for(int i = 0 ; i < dayMax ; i++) {
			d.append("<option value='"+day+"' >"+day+"</option>");
			day++;
		}
		
		c.append("<option value='"+"korea"+"' >"+"한국"+"</option>");
		
		
		date.put("year",  y.toString());
		date.put("month", m.toString());
		date.put("day",   d.toString());
		date.put("contry",c.toString());
		
		
		return JSONObject.toJSONString(date);
	}	
	
	
	
}
