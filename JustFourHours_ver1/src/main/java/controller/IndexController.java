package controller;

import java.sql.SQLException;
import java.util.List;

import model.Book;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CustList;

@Controller
public class IndexController {
	
	 Logger log = Logger.getLogger(this.getClass());
	
	@Autowired 
	private CustList custList;
	
	@RequestMapping("index")
	public String index(Model model) throws SQLException{
		
		List<Book> getList = this.custList.getList();
		
		model.addAttribute("custList",getList);
		 log.debug("인터셉터 테스트");
		
		return "index";
	}
}
