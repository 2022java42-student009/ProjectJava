package la.bean;

import java.io.Serializable;

public class BuyBean implements Serializable {
	private int userid;
	private StockBean book = new StockBean();
	private int selesday;
	private int price;
	private String remarks;
	
	public BuyBean(int userid, StockBean book, int selesday, int price, String remarks) {
		this.userid = userid;
		this.book = book;
		this.selesday = selesday;
		this.price = price;
		this.remarks = remarks;
	}

	public BuyBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public StockBean getBook() {
		return book;
	}

	public void setBook(StockBean book) {
		this.book = book;
	}

	public int getSelesday() {
		return selesday;
	}

	public void setSelesday(int selesday) {
		this.selesday = selesday;
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