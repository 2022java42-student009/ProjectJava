package la.bean;

public class AdminBean {
	private int id;
	private String name;
	private String password;

	public AdminBean(int id, String name,String password) {
		this.id = id;
		this.name = name;
		this.password=password;
		
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}

}