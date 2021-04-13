package jmp.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jmp.spring.vo.BoardVo;

@Service
public interface BoardService {

	public List<BoardVo>getList();
	
	public int insert(BoardVo vo);
	
}
