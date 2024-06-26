package pt05.com.sg.data.dto;

public class UserDto {
	
	private Long userId;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String displayName;
	
	private String avator;
	
	private Long phoneNo;
	
	private String facebookLink;
	
	private String twitterLink;
	
	private String emailToNotify;
	
	private String remarks;
	
	private Long noofdaysToNoti;
	
	private String message;
	
	private String status;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getAvator() {
		return avator;
	}

	public void setAvator(String avator) {
		this.avator = avator;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFacebookLink() {
		return facebookLink;
	}

	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}

	public String getTwitterLink() {
		return twitterLink;
	}

	public void setTwitterLink(String twitterLink) {
		this.twitterLink = twitterLink;
	}

	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getNoofdaysToNoti() {
		return noofdaysToNoti;
	}

	public void setNoofdaysToNoti(Long noofdaysToNoti) {
		this.noofdaysToNoti = noofdaysToNoti;
	}

	public String getEmailToNotify() {
		return emailToNotify;
	}

	public void setEmailToNotify(String emailToNotify) {
		this.emailToNotify = emailToNotify;
	}
	
	
	
	

}
