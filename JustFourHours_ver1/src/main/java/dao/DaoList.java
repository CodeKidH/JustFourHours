package dao;

import java.sql.SQLException;
import java.util.List;

import model.Book;

public interface DaoList {
	
	List<Book> getAll() throws SQLException ;
}