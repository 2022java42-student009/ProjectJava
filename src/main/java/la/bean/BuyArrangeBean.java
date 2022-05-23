package la.bean;

import java.sql.Timestamp;

public class BuyArrangeBean{
	private int userid;
	private Timestamp selesday;
	private String title;
	private int book;
	private String categoryname;
	private int price;
	
	public BuyArrangeBean(int userid,Timestamp selesday, String title, int book, String categoryname, int price) {
		this.selesday = selesday;
		this.title = title;
		this.book = book;
		this.categoryname = categoryname;
		this.price = price;
	}
	
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Timestamp getSelesday() {
		return selesday;
	}

	public void setSelesday(Timestamp selesday) {
		this.selesday = selesday;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}