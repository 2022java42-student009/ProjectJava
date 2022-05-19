package la.bean;

public class AdminBean {
	private int id;
	private String name;

	public AdminBean(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public AdminBean() {

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