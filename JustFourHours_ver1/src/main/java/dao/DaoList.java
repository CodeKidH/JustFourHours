package dao;

import java.sql.SQLException;
import java.util.List;

import model.Book;

public interface DaoList {
	
	List<Book> getAll() throws SQLException ;
	
	public void insertList(Book book) throws SQLException;
	
	List<Book> getOneList(Integer num) throws SQLException;
	
	void delete(String num) throws SQLException;
	
	public void update(Book nook) throws SQLException;
	
	public int getCount() throws SQLException;
	
	Book getSearch(String content)throws SQLException;
}
