package jmp.spring.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

import jmp.spring.mapper.BoardMapper;
import jmp.spring.service.BoardService;
import jmp.spring.vo.BoardVo;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //applicationcontext에 bean을 생성하여 테스트한다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OjdbcTest {
	
	@Autowired
	HikariDataSource dataSource;
	
	@Autowired
	SqlSessionFactory factory;
	
	@Autowired
	BoardMapper boardMapper;
	

		 @Autowired BoardService service;
		
		@Autowired BoardMapper mapper;
		
		@Test public void mapper() { BoardVo vo= new BoardVo(); vo.setContent("내용-");
		vo.setTitle("제목-"); vo.setWriter("작성자-"); mapper.insert(vo);
		  log.info(vo); 
		  log.info(service.insert(vo));
		 }
		 
	
	
	@Test
	public void tmTest() {
		System.out.println(boardMapper.getList());
	}
	
	@Test
	public void sqlSessionFactoryTest() {
		SqlSession sqlSession = factory.openSession();
		sqlSession.getConnection();
	}
	
	@Test
	public void hikariCPTest() {
		try {
			dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	@Test
	public void ojdbcTest()  throws SQLException{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jweb","4321");
		conn.close();
		System.out.println(conn);
	}
}
