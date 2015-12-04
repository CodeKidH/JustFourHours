package service;

import java.sql.SQLException;
import java.util.List;

import model.Book;

public interface CustList {
	
	List<Book> getList() throws SQLException;
	
	public void insertList(Book book) throws SQLException;
	
	List<Book> getOneList(Integer num) throws SQLException;
}
