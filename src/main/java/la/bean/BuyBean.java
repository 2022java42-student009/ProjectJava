package la.bean;

import java.io.Serializable;

public class BuyBean implements Serializable {
	private int userid;
	private int stockid;
	private int price;
	private String remarks;
	
	public BuyBean(int userid, int stockid, int price, String remarks) {
		this.userid = userid;
		this.stockid = stockid;
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

	public int getStockid() {
		return stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
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