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


	
	
}
