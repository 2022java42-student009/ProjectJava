package la.bean;

import java.sql.Timestamp;

public class RegistBean{
	private int id;
	private BookBean book;
	private Timestamp registday;
	private int prise;
	private String remarks;
	
	public RegistBean(int id, BookBean book, Timestamp registday, int prise, String remarks) {
		this.id = id;
		this.book = book;
		this.registday = registday;
		this.prise = prise;
		this.remarks = remarks;
	}
	
	public RegistBean() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BookBean getBook() {
		return book;
	}

	public void setBook(BookBean book) {
		this.book = book;
	}

	public Timestamp getRegistday() {
		return registday;
	}

	public void setRegistday(Timestamp registday) {
		this.registday = registday;
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