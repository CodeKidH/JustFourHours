package controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.Book;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.CustList;

@Controller
public class IndexController {
	
	Logger log = Logger.getLogger(IndexController.class);
	
	@Autowired 
	private CustList custList;
	
	@RequestMapping("index")
	public String index(Model model) throws SQLException{
		
		List<Book> getList = this.custList.getList();
		
		model.addAttribute("custList",getList);
		
		return "index";
	}
	
	@RequestMapping(value="insertMove")
	public String insertMove (){
		return "insert";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insert(HttpServletRequest request, Model model)throws SQLException{
		Book book = new Book();
		
		book.setBook_title((String)request.getParameter("title"));
		book.setCust_name((String)request.getParameter("cust"));
		
		this.custList.insertList(book);
		
		List<Book> getList = this.custList.getList();
		model.addAttribute("custList",getList);
		
		return "index";
	}
	
	@RequestMapping(value="detail")
	public ModelAndView detail(Integer num) throws SQLException{
		
		List<Book> getOneList = this.custList.getOneList(num);
		
		Map<String, Object> model =new HashMap<String, Object>();
		
		model.put("oneList", getOneList.get(0));
		
		ModelAndView modelAndView = new ModelAndView("update");
		modelAndView.addAllObjects(model);
		
		return modelAndView;
	}
	
	
	
}
