package jmp.spring.ojdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.sample.Restaurant;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class sampleTest {
	
	@Autowired
	private Restaurant restaurant;
	
	@Test
	public void test1() {
		System.out.println("test.........");
		log.info("test1.....");
		log.info(restaurant);
	}
}
