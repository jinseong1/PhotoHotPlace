package com.realEstate.www.moving.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/moving") 
public class MovingWeb {
	
	@RequestMapping("/searchMainAction" )
	public String searchMoving(@RequestParam Map<String,Object> map ,Model model) {
		model.addAttribute("searchData", map.get("searchData").toString());
		return "/photo/mainPhotoList";
	}
	
	@RequestMapping("/photoDetail")
	public String photoDetail(@RequestParam Map<String,Object> map ,Model model) {

	    model.addAttribute("no", map.get("no"));
		
		return "/photo/photoDetail";
	}	
	
	@RequestMapping("/photoWrite")
	public String photoWrite(@RequestParam Map<String,Object> map ,Model model) {
		return "/photo/photoWrite";
	}		
	
	@RequestMapping("/login" )
	public String loginPageMoving(@RequestParam Map<String,Object> map ,Model model) {
		return "/customs/login/login";
	}
	@RequestMapping("/logout" )
	public String logout(@RequestParam Map<String,Object> map ,Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return "/customs/login/login";
	}	
	
	
	
	@RequestMapping("/singUp" )
	public String singUpPageMoving(@RequestParam Map<String,Object> map ,Model model) {
		return "/customs/login/singUp";
	}
	
	
	
	
	
	
	
}
