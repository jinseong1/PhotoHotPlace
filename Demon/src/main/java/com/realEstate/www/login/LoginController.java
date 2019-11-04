package com.realEstate.www.login;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.realEstate.www.login.service.impl.LoginService;
import com.realEstate.www.login.service.impl.LoginServiceImpl;

@Controller
@RequestMapping("/login") 
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	
	/**
	 * 2019-11-04 박진성 
	 * 로그인 처리 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/customsLogin",produces="text/html; charset=UTF-8", method = RequestMethod.POST)
	public String getSearchList(@RequestParam Map<String, String> map, HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		
		int result = loginService.login(map);
		
		if(result > 0) {
			session.setAttribute("C_ID", map.get("id").toString());
		} else {
			session.invalidate();
		}
		
		return String.valueOf(result);
	}
	
	/**
	 * 2019-11-04 박진성 
	 * 가입 처리 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/singUp",produces="text/html; charset=UTF-8", method = RequestMethod.POST)
	public String singUp(@RequestParam Map map) throws Exception{
		int result = loginService.singup(map);
		return String.valueOf(result);
	}
	/**
	 * 2019-11-04 박진성 
	 * 가입 - 프로필 사진 업로드  
	 * @param map
	 * @return
	 * @throws Exception
	 */

	@ResponseBody
	@RequestMapping(value="/profileSave",produces="text/html; charset=UTF-8")
	public String profileSave(MultipartHttpServletRequest multipartRequest) throws Exception{
		
		List<HashMap> fileArrayList = new ArrayList<HashMap>();
	    HashMap<Object, Object> fileHashMap;
	    
	    String filePath = "C:/test"; //파일 경로 
	    
		Iterator<String> itr =  multipartRequest.getFileNames(); //파일들을 Iterator 에 넣는다.
		 
	    while (itr.hasNext()) { //파일을 하나씩 불러온다.
	 
	        MultipartFile mpf = multipartRequest.getFile(itr.next());
	 
	        fileHashMap = new HashMap<Object, Object>();
	 
	        String originalFilename = mpf.getOriginalFilename(); //파일명
	 
	        String fileFullPath = filePath+"/"+originalFilename; //파일 전체 경로
	        
	        System.out.println("filename : "+originalFilename);
	        System.out.println("filePath : "+fileFullPath);
	        
	        try {
	            //파일 저장
	            //mpf.transferTo(new File(fileFullPath)); //파일저장
	 
	            //fileHashMap.put("originalFilename", originalFilename);
	            //fileHashMap.put("fileFullPath", fileFullPath);
	 
	            //fileArrayList.add(fileHashMap);
	 
	        } catch (Exception e) {
	            System.out.println("postTempFile_ERROR======>"+fileFullPath);
	            e.printStackTrace();
	        }
	 
	    }
	    
	    return "1";
	}	

	
	//생년월일에 사용할 날짜 얻기.
	@ResponseBody
	@RequestMapping(value="/getDate",produces="text/html; charset=UTF-8", method = RequestMethod.POST)
	public String getDate(@RequestParam Map map) throws Exception{
		
		Map<String, String> date = new HashMap<String, String>();
		
		SimpleDateFormat format = new SimpleDateFormat ("yyyy");
		
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
			
			String month = null;
			if(mt < 10) {
				month = "0"+mt;
			} else {
				month = String.valueOf(mt);
			}
			
			m.append("<option value='"+month+"' >"+month+"</option>");
			mt++;
		}
		int day = 1;
		int dayMax = calendar.getMaximum(Calendar.DAY_OF_MONTH);
		for(int i = 0 ; i < dayMax ; i++) {
			String dayStr = null;
			if(day < 10) {
				dayStr = "0"+day;
			} else {
				dayStr = String.valueOf(day);
			}
			d.append("<option value='"+dayStr+"' >"+dayStr+"</option>");
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
