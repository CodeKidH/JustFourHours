package service.impl;

import java.sql.SQLException;
import java.util.List;

import model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import service.CustList;
import dao.DaoList;

@Service()
public class CustListImpl implements CustList{
	
	@Autowired
	private DaoList daoList;
	
	public List<Book> getList() throws SQLException {
		return this.daoList.getAll();
	}
	
	public void insertList(Book book) throws SQLException{
		 this.daoList.insertList(book);
	}
	
	public List<Book> getOneList(Integer num) throws SQLException{
		return this.daoList.getOneList(num);
	}
	
	public void delete(String num) throws SQLException{
		this.daoList.delete(num);
	}
	
	public void update(Book book) throws SQLException{
		this.daoList.update(book);
	}
	
	public int getCount()throws SQLException{
		return this.daoList.getCount();
	}
}
