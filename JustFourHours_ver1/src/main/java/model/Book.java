package model;

import java.io.Serializable;

public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public String num;
	public String cust_name;
	public String book_title;
	public String borrow_date;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}
	
}
