package la.bean;

import java.sql.Timestamp;

public class MemberBean {
	private int  id;
	private String name;
	private String address;
	private int tel;
	private String mail;
	private String birthday;
	private Timestamp admissionday;
	private Timestamp leaveday;
	private String password;
	public MemberBean(int id, String name, String address, int tel, String mail, String birthday,
			Timestamp admissionday, Timestamp leaveday, String password) {
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
		this.birthday = birthday;
		this.admissionday = admissionday;
		this.leaveday = leaveday;
		this.password = password;
	}
	public MemberBean(String name, String address, int tel, String mail, String birthday, String password) {
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
		this.birthday = birthday;
		this.password = password;
	}
	public MemberBean() {
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Timestamp getAdmissionday() {
		return admissionday;
	}
	public void setAdmissionday(Timestamp admissionday) {
		this.admissionday = admissionday;
	}
	public Timestamp getLeaveday() {
		return leaveday;
	}
	public void setLeaveday(Timestamp leaveday) {
		this.leaveday = leaveday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}