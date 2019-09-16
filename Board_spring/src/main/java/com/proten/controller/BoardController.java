package com.proten.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.proten.bean.BoardVO;
import com.proten.bean.PageMaker;
import com.proten.bean.PageMaker2;
import com.proten.bean.PageVO;
import com.proten.bean.SearchBean;
import com.proten.service.BoardService;



@Controller
@RequestMapping("/board")// 요청경로(path) url
public class BoardController {
	
	@Autowired
	private BoardService ser;//PageVO pvo, 
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)// 뷰 폴더 안 요청경로(path)
	public void getList(Model model, PageVO pvo) {
	
		List<BoardVO> list = ser.list(pvo);
		model.addAttribute("list", list);// Model은 컨트롤러에서 처리한 결과를 화면에 전달하는 역할을 합니다. "Model은 컨트롤러(Controller)와 뷰(View)를 연결해주는 역할을 합니다
		
		PageMaker pm = new PageMaker();
		pm.setPvo(pvo);
		pm.setTotalCount(ser.count());
		model.addAttribute("pm", pm);
	}
	@RequestMapping(value = "/listSearch", method = RequestMethod.GET)// 뷰 폴더 안 요청경로(path)
	public String getList(Model model, PageVO pvo,  SearchBean sb, @RequestParam("select") int selNo, @RequestParam("order") String order) {
		sb.setPerPageNum(selNo);
		sb.setOrderBy(order);
		List<BoardVO> list = ser.list(sb);
		model.addAttribute("list", list);// Model은 컨트롤러에서 처리한 결과를 화면에 전달하는 역할을 합니다. "Model은 컨트롤러(Controller)와 뷰(View)를 연결해주는 역할을 합니다
		
		PageMaker pm = new PageMaker();
		pm.setPvo(sb);
		pm.setTotalCount(ser.count());
		model.addAttribute("pm", pm);
		
		return "redirect:/board/list?page=" + pvo.getPage() +
				"&perPageNum=" + selNo + "&orderBy=" + order;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)// 뷰 폴더 안 요청경로(path)
	public String list(PageVO pvo, @RequestParam("select") int selNo, SearchBean sb, @RequestParam("order") String order) {
		pvo.setPerPageNum(selNo);
		ser.list(pvo);
		
		sb.setOrderBy(order);
		ser.listSearch(sb);
		
		PageMaker pm = new PageMaker();
		pm.setPvo(pvo);
		System.out.println(selNo);
		System.out.println(order);
		return "redirect:/board/list?page=" + pvo.getPage() +
				"&perPageNum=" + selNo + "&orderBy=" + order;
	}
	
	@RequestMapping(value = "/listSearch", method = RequestMethod.POST)// 뷰 폴더 안 요청경로(path)
	public String list(PageVO pvo, SearchBean sb, @RequestParam("order") String order) {

		sb.setOrderBy(order);
		ser.listSearch(sb);
		PageMaker pm = new PageMaker();
		pm.setPvo(pvo);
		System.out.println(order);
		return "redirect:/board/listSearch?page=" + pvo.getPage() +
				"&perPageNum=" + pvo.getPerPageNum();
	}
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String getinsert() {
		return "board/insert";//뷰폴더 안에 board 폴더란 의미
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)//뷰 안에 경로와 일치하기 때문에 form에 액션 안써줌
	public String insert(BoardVO vo) {

		ser.insert(vo);
		return "redirect:/board/list";
		//redirect가 있다면 컨트롤러의 메서드를 통해 설정된 경로로 데이터를 가진채 이동하게 됩니다. 
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)//보이드 겟
	public String view(@RequestParam("no") int no, Model model, PageVO pvo) {//@RequestParam 어노테이션을 사용하면 url로 온 매개변수 no 사용 가능
		
		
		model.addAttribute("pvo", pvo);
		BoardVO view = ser.view(no);
		model.addAttribute("view",view);
		return "board/view";
		//no를 받는 방법은 여러가지. 우리는 리퀘파람으로(url파라미터) 받았고, 누구는 jsp에 히든으로 no 폼으로 (name=param) 전송
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void getupdate(@RequestParam("no") int no, Model model) {//url 뒤 파라미터는 url경로로 안 쳐줌.
		
		BoardVO view = ser.view(no);
		model.addAttribute("view",view);
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO vo, Model model) {//jsp에서 폼 파라미터 포스트로 보내서 여기 오고 그 값을 vo에 업데이트 해서getNo. 그래서 히든no가필요

		ser.update(vo);
		//
		return "redirect:/board/view?no=" + vo.getNo();
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST )
	public String delete(@RequestParam("check") int no) {
		
		ser.delete(no);
		//ser.delete(no2);
		
		return "redirect:/board/list";
	}
	

}
