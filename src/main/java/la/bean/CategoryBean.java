package la.bean;

import java.io.Serializable;

public class CategoryBean implements Serializable{
	private int id;
	private String name;
	
	public CategoryBean(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public CategoryBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
