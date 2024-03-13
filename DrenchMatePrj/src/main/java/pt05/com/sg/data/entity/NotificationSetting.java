package pt05.com.sg.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;


@Entity
@Table(name = "TB_NOTIFICATION_SETTING")
public class NotificationSetting extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3948639919682483882L;
	
	@Id
	@GeneratedValue(generator="SEQ_NOTIFICATION_ID",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="SEQ_NOTIFICATION_ID",sequenceName="SEQ_NOTIFICATION_ID", allocationSize=1)
	@Column(name = "NotiSettingId")
	private long notiSettingId;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "UserId")
	private User user;
	
	@Column(name = "ToReceiveNotification")
	private char toReceiveNotification;
	
	@Column(name = "Email")
	private String email;
	
	
	@Column(name = "NoOfDays")
	private Long noOfDays;

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

	public NotificationSetting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getNotiSettingId() {
		return notiSettingId;
	}

	public void setNotiSettingId(long notiSettingId) {
		this.notiSettingId = notiSettingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public char getToReceiveNotification() {
		return toReceiveNotification;
	}

	public void setToReceiveNotification(char toReceiveNotification) {
		this.toReceiveNotification = toReceiveNotification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Long noOfDays) {
		this.noOfDays = noOfDays;
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
	
	

}
