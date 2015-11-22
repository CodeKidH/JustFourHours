package dao.impl;

import java.util.List;

import javax.sql.DataSource;

import model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.DaoList;

@Repository
public class DaoListImpl implements DaoList{
	
	private SimpleJdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.template = new SimpleJdbcTemplate(dataSource);
	}
	
	private static final String SELECT_ALL = "SELECT num, cust_name, book_title, borrow_date FROM CUSTOMER_LIST";
	
	public List<Book> getAll(){
		RowMapper<Book> mapper = new BeanPropertyRowMapper<Book>(Book.class);
		return this.template.query(DaoListImpl.SELECT_ALL, mapper);
	}
	
	
}
