package pt05.com.sg.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "TB_NOTIFICATION")
public class Notification extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9148316350061705515L;
	
	@Id
	@GeneratedValue(generator="SEQ_NOTIFICATION_ID",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="SEQ_NOTIFICATION_ID",sequenceName="SEQ_NOTIFICATION_ID", allocationSize=1)
	@Column(name = "NotificationId")
	private long notificationId;
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="FarmHouseId")
	private FarmHouse farmHouse;
	
	@Column(name = "Message")
	private String message;
	
	@Column(name = "NotiType")
	private String notiType;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "Remarks")
	private String remarks;
	
	@Column(name = "DateOfNotification")
	private Date dateOfNotification;
	
	
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

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNotiType() {
		return notiType;
	}

	public void setNotiType(String notiType) {
		this.notiType = notiType;
	}

	public String getStatus() {
		return status;
	}
	
	

	public FarmHouse getFarmHouse() {
		return farmHouse;
	}

	public void setFarmHouse(FarmHouse farmHouse) {
		this.farmHouse = farmHouse;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getDateOfNotification() {
		return dateOfNotification;
	}

	public void setDateOfNotification(Date dateOfNotification) {
		this.dateOfNotification = dateOfNotification;
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
