package la.bean;

import java.sql.Timestamp;

public class RegistArrangeBean{
	private int book;
	private String title;
	private String author;
	private String categoryname;
	private Timestamp registday;
	private int prise;
	private String remarks;
	
	public RegistArrangeBean(int book, String title, String author, String categoryname, Timestamp registday, int prise,
			String remarks) {
		this.book = book;
		this.title = title;
		this.author = author;
		this.categoryname = categoryname;
		this.registday = registday;
		this.prise = prise;
		this.remarks = remarks;
	}

	public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
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

