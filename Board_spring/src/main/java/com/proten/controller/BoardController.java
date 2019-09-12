package com.proten.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.proten.bean.BoardVO;
import com.proten.service.BoardService;



@Controller
@RequestMapping("/board")// 요청경로(path)
public class BoardController {
	
	@Autowired
	private BoardService ser;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)// 뷰 폴더 안 요청경로(path)
	public void list(Model model) {
		
		List<BoardVO> list = ser.selcet();
		model.addAttribute("list", list);//(넘기는 이름,넘길거), Model은 컨트롤러에서 처리한 결과를 화면에 전달하는 역할을 합니다. "Model은 컨트롤러(Controller)와 뷰(View)를 연결해주는 역할을 합니다
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void getinsert() {
		//return "board/insert";
	}
	
	@RequestMapping(value = "/insert2", method = RequestMethod.POST)//뷰 안에 경로와 일치하기 때문에 form에 액션 안써줌
	public String insert(BoardVO vo) {

		ser.insert(vo);
		return "redirect:/board/list";
		//redirect가 있다면 컨트롤러의 메서드를 통해 설정된 경로로 데이터를 가진채 이동하게 됩니다. 
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)//보이드 겟
	public String view(@RequestParam("no") int no, Model model) {//@RequestParam 어노테이션을 사용하면 url로 온 매개변수 no 사용 가능

		BoardVO view = ser.view(no);
		model.addAttribute("view",view);
		return "board/view";
		//no를 받는 방법은 여러가지. 우리는 리퀘파람으로(url파라미터) 받았고, 누구는 jsp에 히든으로 no 폼으로 전송
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
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("check") int no) {
		
		ser.delete(no);
		//ser.delete(no2);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public void page(Model model) {
		int count = ser.count();
		int postNum = 5;
		int PageNum = (int)Math.ceil(count/postNum);
		
	}
}
