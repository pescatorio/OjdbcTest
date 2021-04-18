package jmp.spring.ojdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.mapper.BoardMapper;
import jmp.spring.service.BoardService;
import jmp.spring.vo.BoardVo;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:srcfile:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ServiceTest2 {

	@Autowired
	BoardService service;
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void mapper() {
		BoardVo vo= new BoardVo();
		vo.setContent("내용입니다.");
		vo.setTitle("제목입니다.");
		vo.setWriter("작성자입니다.");
		mapper.insert(vo);
		log.info(service.insert(vo));
		
	}
}
