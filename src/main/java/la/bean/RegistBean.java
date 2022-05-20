package la.bean;

import java.security.Timestamp;

public class RegistBean{
	private int id;
	private int book_number;
	private BookBean book = new BookBean();
	private Timestamp regist_day;
	private int prise;
	private String remarks;
	
	public RegistBean(int id, int book_number, BookBean book, Timestamp regist_day, int prise, String remarks) {
		this.id = id;
		this.book_number = book_number;
		this.book = book;
		this.regist_day = regist_day;
		this.prise = prise;
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBook_number() {
		return book_number;
	}

	public void setBook_number(int book_number) {
		this.book_number = book_number;
	}

	public BookBean getBook() {
		return book;
	}

	public void setBook(BookBean book) {
		this.book = book;
	}

	public Timestamp getRegist_day() {
		return regist_day;
	}

	public void setRegist_day(Timestamp regist_day) {
		this.regist_day = regist_day;
	}

	public int getPrise() {
		return prise;
	}

	public void setPrise(int prise) {
		this.prise = prise;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}