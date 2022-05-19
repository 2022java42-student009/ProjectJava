package la.bean;

public class BookBeen {
	private int isbm;
	private String title;
	private int category;
	private String author;
	public BookBeen(int isbm, String title, int category, String author) {
		this.isbm = isbm;
		this.title = title;
		this.category = category;
		this.author = author;
	}
	public BookBeen() {
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
