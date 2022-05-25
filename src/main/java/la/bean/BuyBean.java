package la.bean;

import java.io.Serializable;

public class BuyBean implements Serializable {
	private int userid;
	private int booknumber;
	private String stock_state;
	private int price;
	private String remarks;
	
	public BuyBean(int userid, int booknumber, String stock_state, int price, String remarks) {
		this.userid = userid;
		this.booknumber = booknumber;
		this.stock_state = stock_state;
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

	public int getBooknumber() {
		return booknumber;
	}

	public void setBooknumber(int booknumber) {
		this.booknumber = booknumber;
	}

	public String getStock_state() {
		return stock_state;
	}

	public void setStock_state(String stock_state) {
		this.stock_state = stock_state;
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