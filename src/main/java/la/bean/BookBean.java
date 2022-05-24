package la.bean;

import java.io.Serializable;

public class BookBean implements Serializable{
	private int isbm;
	private String title;
	private int categoryid;
	private String categoryname;
	private String author;
	
	public BookBean(int isbm, String title, int categoryid, String categoryname, String author) {
		this.isbm = isbm;
		this.title = title;
		this.categoryid = categoryid;
		this.categoryname = categoryname;
		this.author = author;
	}
	public BookBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public int getIsbm() {
		return isbm;
	}
	public void setIsbm(int isbm) {
		this.isbm = isbm;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategory(int categoryid) {
		this.categoryid = categoryid;
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
	
	
}
