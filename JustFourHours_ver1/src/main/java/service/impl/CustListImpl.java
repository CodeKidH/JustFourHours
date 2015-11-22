package service.impl;

import java.util.List;

import model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.CustList;
import dao.DaoList;

@Service
public class CustListImpl implements CustList{
	
	@Autowired
	private DaoList daoList;
	
	public List<Book> getList(){
		return this.daoList.getAll();
	}
}
