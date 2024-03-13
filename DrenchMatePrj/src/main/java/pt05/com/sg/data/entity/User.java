package pt05.com.sg.data.entity;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "TB_USER")
public class User extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="SEQ_USER_ID",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="SEQ_USER_ID",sequenceName="SEQ_USER_ID", allocationSize=1)
	@Column(name = "UserId")
	private long userId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Roles")
	private String roles;
	
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile userProfile;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FarmHouse> farmHouseList=new ArrayList<>();
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private NotificationSetting notificationSetting;


	@Version
	@Column(name = "VerNo")
	private long verNo;
	
	@Column(name = "CreatedDate")
	private Date createdDate;
	
	@Column(name = "CreatedBy")
	private String createdBy;
	
	@Column(name = "LastUpdatedDate")
	private Date lastUpdatedDate;
	
	@Column(name = "LastedUpdatedBy")
	private String lastUpdatedBy;
	
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(User u) {
		this.name = u.getName();
		this.email = u.getEmail();
		this.password = u.getPassword();
		this.roles=u.getRoles();
	}


	public User( String name, String email, String password,String createdBy,Date createdDate,String lastUpdatedBy,Date lastUpdatedDate,String roles) {
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles=roles;
		this.createdBy=createdBy;
		this.createdDate=createdDate;
		this.lastUpdatedBy=lastUpdatedBy;
		this.lastUpdatedDate=lastUpdatedDate;
	}



	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public List<FarmHouse> getFarmHouseList() {
		return farmHouseList;
	}

	public void setFarmHouseList(List<FarmHouse> farmHouseList) {
		this.farmHouseList = farmHouseList;
	}

	public long getVerNo() {
		return verNo;
	}

	public void setVerNo(long verNo) {
		this.verNo = verNo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	public NotificationSetting getNotificationSetting() {
		return notificationSetting;
	}

	public void setNotificationSetting(NotificationSetting notificationSetting) {
		this.notificationSetting = notificationSetting;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", roles="
				+ roles + "]";
	}


}
