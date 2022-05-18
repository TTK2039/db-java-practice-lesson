package entity;

public class User {
	private Integer userId;
	private String userName;
	private String mail;
	private String pass;
	
	public Integer getId() {
		return userId;
	}
	public void setId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return userName;
	}
	public void setName(String userName) {
		this.userName = userName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
		
	
	public User() {
	}

	public User(Integer userId, String userName, String mail, String pass) {
	    this.userId = userId;
	    this.userName = userName;
	    this.mail = mail;
	    this.pass = pass;
	}

}


