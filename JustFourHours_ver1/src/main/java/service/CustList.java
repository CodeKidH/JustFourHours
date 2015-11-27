package service;

import java.sql.SQLException;
import java.util.List;

import model.Book;

public interface CustList {
	
	List<Book> getList() throws SQLException;
}
