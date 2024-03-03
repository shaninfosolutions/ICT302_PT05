package pt05.com.sg.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "TB_USER_PROFILE")
public class UserProfile extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1807962861136923712L;
	
	@Id
    @Column(name = "UserId")
	private long userId;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "UserId")
	private User user;
	
	@Column(name = "DisplayName")
	private String displayName;
	
	@Column(name = "Avator")
	private String avator;
	
	
	@Column(name = "PhoneNo")
	private Long phoneNo;
	
	
	@Column(name = "FacebookLink")
	private String facebookLink;
	
	@Column(name = "TwitterLink")
	private String twitterLink;
	
	
	@Column(name = "Remarks")
	private String Remarks;
	
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

	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserProfile(UserProfile userProfile) {
		this.setDisplayName(userProfile.getDisplayName());
		this.setAvator(userProfile.getAvator());
		this.setPhoneNo(userProfile.getPhoneNo());
		this.setFacebookLink(userProfile.getFacebookLink());
		this.setTwitterLink(userProfile.getTwitterLink());
		this.setRemarks(userProfile.getRemarks());
		this.setCreatedBy(userProfile.getCreatedBy());
		this.setCreatedDate(new Date());
		this.setLastUpdatedBy(userProfile.getLastUpdatedBy());
		this.setLastUpdatedDate(new Date());
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Override
	public String toString() {
		return "UserProfile [user=" + user + ", displayName=" + displayName + ", avator=" + avator + ", phoneNo="
				+ phoneNo + ", facebookLink=" + facebookLink + ", twitterLink=" + twitterLink + ", Remarks=" + Remarks
				+ ", verNo=" + verNo + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}
	

}
