package controller;

import java.sql.SQLException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.CustList;

@Controller
public class IndexController {
	
	Logger log = Logger.getLogger(IndexController.class);
	
	@Autowired 
	private CustList custList;
	
	@RequestMapping("index")
	public ModelAndView index(@RequestParam(value="currentPage",defaultValue="1")int currentPage) throws SQLException{
		
		Map<String,Object> model = new HashMap<>();
		List<Object> currentPageCount = new ArrayList<>(); 
		ModelAndView modelAndView = new ModelAndView();
		int k = 0;
		int pageCount = 0;
		int size = 0;
		int count = this.custList.getCount();
		int innerSize = count;
		List<Book> getList = this.custList.getList();
		
		if(getList.size() < 3){
			size = getList.size();
		}else{
			size = 3;
		}
		
		Object[] pageContents = new Object[size];
		
		for(int i = 0; i< getList.size(); i++){
			
			pageContents[k] = getList.get(i);
			
			i = i+1;
			k = k+1;
			if(i % 3 == 0 && i != 0){
				 currentPageCount.add(pageContents);
				 
				 innerSize = innerSize - 3;
				 
				 if(innerSize < 3){
					 size = innerSize;
				 }else {
					 size = 3;
				 }
				 pageContents = new Object[size];
				 i = i-1;
				 k = 0;
			}else{
				 i = i-1;
			}
			
		}
		System.out.println(org.springframework.core.SpringVersion.getVersion());
		currentPageCount.add(pageContents);
		
		if(count % 3 == 0){
			pageCount = count/3 + 1;
		}else{
			pageCount = count/3 + 2;
		}
		
		currentPage = currentPage -1;
		
		model.put("custList", currentPageCount.get(currentPage));
		model.put("totalCount", count);
		model.put("pageCount",pageCount);
		
		modelAndView.addAllObjects(model);
		
		return modelAndView;
		
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
	public ModelAndView detail(@RequestParam int num) throws SQLException{
		
		List<Book> getOneList = this.custList.getOneList(num);
		
		Map<String, Object> model =new HashMap<String, Object>();
		
		model.put("oneList", getOneList.get(0));
		
		ModelAndView modelAndView = new ModelAndView("update");
		modelAndView.addAllObjects(model);
		
		return modelAndView;
	}
	
	@RequestMapping(value="delete")
    public String delete(@RequestParam String num) throws Exception {
    	
    	 custList.delete(num);
    	 
    	 return "redirect:/index.html";
    	
    }
	
	@RequestMapping(value="update")
	public String update(HttpServletRequest request, RedirectAttributes redirectAttributes) throws SQLException{
		
		Book book = new Book();
		
		book.setBook_title(request.getParameter("title"));
		book.setCust_name(request.getParameter("cust"));
		book.setNum(request.getParameter("num"));
		
		this.custList.update(book);
		
		 //redirectAttributes.addAttribute("num", request.getParameter("num"));
		
		return "redirect:/index.html";
	}
	
	@ResponseBody
	@RequestMapping(value="search", method=RequestMethod.GET)
	public  HashMap<String,Object> search(@RequestParam(value="content") String content) throws SQLException{
		
		Book getBook = this.custList.getSearch(content);
		
		HashMap<String,Object> map = new HashMap<>();
		map.put("title", getBook.book_title);
		map.put("name", getBook.cust_name);
		map.put("num", getBook.num);
		
		
		return map;
	}
	
}
