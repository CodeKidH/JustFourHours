package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.DaoList;

@SuppressWarnings("unchecked") 
@Repository
public class DaoListImpl implements DaoList{
	
	@Autowired
    private SqlMapClient query;
	
	
	public List<Book> getAll() throws SQLException{
		
		List<Book> bookList = query.queryForList("Book.getBookList");
		return bookList;
	}
	
	public void insertList(Book book) throws SQLException{
		query.insert("Book.insertBook", book);
	}
	
	public List<Book> getOneList(Integer num) throws SQLException{
		
		List<Book> getOneList = query.queryForList("Book.detail",num);
		return getOneList;
	}
	
	public void delete(String num) throws SQLException{
		query.delete("Book.delete",num);
	}

	public void update(Book book) throws SQLException{
		query.update("Book.update",book);
	}
	
	public int getCount()throws SQLException{
		
		return  (int) query.queryForObject("Book.getCount");
		
	}
	
	public Book getSearch(String book_title) throws SQLException{
		
		Book getSearch = (Book) query.queryForObject("Book.getSearch",book_title);
		return getSearch;
	}
	
	
}
