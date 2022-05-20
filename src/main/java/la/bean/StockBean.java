package la.bean;

public class StockBean {
	private int id;
	private BookBean book = new BookBean();
	private String state;
	private int price;
	private String remarks;
	
	public StockBean(int id, BookBean book, String state, int price, String remarks) {
		this.id = id;
		this.book = book;
		this.state = state;
		this.price = price;
		this.remarks = remarks;
	}
	public StockBean() {
		// TODO 自動生成されたコンストラクター・スタブ
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}