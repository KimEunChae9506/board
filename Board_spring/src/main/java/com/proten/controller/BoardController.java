package com.proten.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proten.bean.BoardVO;
import com.proten.bean.PageMaker;
import com.proten.bean.PageVO;
import com.proten.service.BoardService;



@Controller
@RequestMapping("/board")// 요청경로(path) url
public class BoardController {
	
	@Autowired
	private BoardService ser;//PageVO pvo, 
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model, PageVO pvo) {
	
		List<BoardVO> list = null;
		list = ser.list(pvo);
		model.addAttribute("list", list);// Model은 컨트롤러에서 처리한 결과를 화면에 전달하는 역할

			System.out.println(list);
		
		PageMaker pm = new PageMaker();
		pm.setPvo(pvo);
		pm.setTotalCount(ser.count(pvo));
		model.addAttribute("pvo", pvo);
		model.addAttribute("pm", pm);
		return "board/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String list(PageVO pvo, @RequestParam("numsel") int selNo, @RequestParam("orderBy") String order, @RequestParam("search") String search) {
		pvo.setPerPageNum(selNo);
		pvo.setOrderBy(order);
		pvo.setSearch(search);
		ser.list(pvo);
		
		
		PageMaker pm = new PageMaker();
		pm.setPvo(pvo);
		pm.setTotalCount(ser.count(pvo));
		return "redirect:/board/list?page=" + pvo.getPage() +
				"&perPageNum=" + selNo+ "&orderBy=" +order + "&search=" + encode(search);
	}
	
	
	private String encode(String search) {
		 try {
			  return URLEncoder.encode(search, "UTF-8");
			 } catch(UnsupportedEncodingException e)
			 { return ""; 
			 }
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String getinsert() {
		return "board/insert";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BoardVO vo) {

		ser.insert(vo);
		return "redirect:/board/list";
		//redirect가 있다면 컨트롤러의 메서드를 통해 설정된 경로로 데이터를 가진채 이동 
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(@RequestParam("no") int no, Model model, PageVO pvo) {//@RequestParam 어노테이션을 사용하면 url로 온 매개변수 no 사용 가능
		BoardVO view = ser.view(no);
		model.addAttribute("view",view);
		model.addAttribute("pvo", pvo);
		return "board/view";
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String getupdate(@RequestParam("no") int no, Model model, PageVO pvo) {
		
		BoardVO view = ser.view(no);
		model.addAttribute("view",view);
		model.addAttribute("pvo", pvo);
		return "board/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO vo, Model model) {//jsp에서 폼  내 모든 파라미터 보내야 에러 안 남. 그래서 히든no가필요
		ser.update(vo);
		
		return "redirect:/board/view?no=" + vo.getNo();
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("check") int[] no, PageVO pvo, RedirectAttributes rttr) {
		for(int i=0; i<no.length; i++) {
		ser.delete(no[i]);
		}
		rttr.addAttribute("page", pvo.getPage());//리다이렉트시 get 방식으로 파라미터 전달
		rttr.addAttribute("perPageNum", pvo.getPerPageNum());
		rttr.addAttribute("search", pvo.getSearch());
		return "redirect:/board/list";
	}
	

}
