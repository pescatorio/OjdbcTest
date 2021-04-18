package jmp.spring.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jmp.spring.mapper.BoardMapper;
import jmp.spring.service.BoardService;
import jmp.spring.vo.BoardVo;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class boardController {

	@Autowired
	BoardService service;
	@Autowired
	BoardMapper mapper;
	
	public void mapper() {
		BoardVo vo= new BoardVo();
		mapper.insert(vo);
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list",service.getList());
		log.info("list");
	}
	
	@GetMapping("/register")
	public void insert() {
		log.info("list");
	}
	
	@PostMapping("/register")
	public String insertExe(BoardVo vo,RedirectAttributes rttr) {
		
		log.info(vo);
		int res = service.insert(vo);
		String resMsg="";
		//한번만 글을 띄어주는 메서드
		if(res>0) {
			resMsg="등록되었습니다.";
			rttr.addFlashAttribute("resMsg",vo.getBno()+"번 게시글이 등록되었습니다.");
		}else {
			resMsg="등록 실패";
			rttr.addFlashAttribute("resMsg");
		}
			
		return "redirect:/board/list";
	}
}
