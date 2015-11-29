package controller;

import java.sql.SQLException;
import java.util.List;

import model.Book;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CustList;

@Controller
public class IndexController {
	
	 Logger log = Logger.getLogger(IndexController.class);
	
	@Autowired 
	private CustList custList;
	
	@RequestMapping("index")
	public String index(Model model) throws SQLException{
		
		PatternLayout pattern = new PatternLayout("%t> [%d{yyyy-MM-dd HH:mm:ss}] [%c{1}] [%L] [%p] %m %n");
		List<Book> getList = this.custList.getList();
		log.addAppender(new ConsoleAppender(pattern));
		log.debug("인터셉터 테스트");
		
		model.addAttribute("custList",getList);
		
		return "index";
	}
}
