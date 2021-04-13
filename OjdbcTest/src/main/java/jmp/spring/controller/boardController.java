package jmp.spring.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jmp.spring.mapper.BoardMapper;
import jmp.spring.service.BoardService;
import jmp.spring.vo.BoardVo;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class boardController {

	@Autowired
	BoardService service;
	@Autowired
	BoardMapper mapper;
	@Test
	public void mapper() {
		BoardVo vo= new BoardVo();
		mapper.insert(vo);
	}
	
	@Test
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
	public String insertExe(BoardVo vo) {
		log.info(vo);
		int res = service.insert(vo);
		
		return "redirect:/board/list";
	}
}
