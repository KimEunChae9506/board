package com.proten.controller;

import java.text.DateFormat;

import java.util.Locale;


import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proten.bean.BoardVO;
import com.proten.service.BoardService;



@Controller
public class HomeController {
	
	@Autowired
	private BoardService ser;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String getinsert() {
		return "test";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String insert(BoardVO vo) {
		
		
		
		ser.insert(vo);
		return "redirect:/";
	}
	
}
