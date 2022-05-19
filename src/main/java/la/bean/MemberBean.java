package la.bean;

public class MemberBean {
	private int id;
	private String name;
	private String addres;
	private int tel;
	private String mail;
	private String birthday;
	private String admissiionday;
	private String password;

	public MemberBean(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public MemberBean() {

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