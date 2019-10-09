package com.realEstate.www.photo.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/phothList") 
public class PhotoListController {
	

	//특정 글번호에 대한 코멘트 전체 목록 가져오기
	@ResponseBody
	@RequestMapping(value="/getSearchList",produces="text/html; charset=UTF-8", method = RequestMethod.POST)
	public String getSearchList(@RequestParam Map<String, String> map,@ModelAttribute("searchData")String pid) throws Exception{
		
		StringBuffer bf = new StringBuffer();
		
		
		for(int z = 0 ; z < 10 ; z++) {
			
			int index = z/2;
			
			String floats;
			
			if(index == 0){
				floats = "left";
			} else {
			    floats = "right";
			}
	
			bf.append("     <div style=\"width:50%; border-style:dashed;float:"+floats+";\" class=\"divPhoto\">\n" + 
			          "        <a href = 'javascript:pageReadyAction(2)'>"+
					  "        <div style=\"width:80%;height:80%; margin:1% 10%\">\n" + 
					  "        사진 넣을 부분" + 
					  "        </div>\n" +
					  "        <div style='text-align: center;'>사진설명 넣을 부분</div> "+
					  "        </a>"+
					  "     </div>");
		   if(z == 9) {
			   bf.append("<div>&nbsp; </div>\n" + 
			   		     "<div class=\"container\" style='width:300px; background:hotpink'>페이징 영역</div>");
		   }
			
		}
		
		return bf.toString() ;
		//return JSONArray.toJSONString(listPhotoData);
	}
	
	
	
}
