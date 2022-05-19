package la.bean;

import java.io.Serializable;

public class BookBean implements Serializable{
	private int isbm;
	private String title;
	private int category;
	private String author;
	public BookBean(int isbm, String title, int category, String author) {
		this.isbm = isbm;
		this.title = title;
		this.category = category;
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
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
