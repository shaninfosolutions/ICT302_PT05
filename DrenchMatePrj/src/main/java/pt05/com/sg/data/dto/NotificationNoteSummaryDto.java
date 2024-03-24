package pt05.com.sg.data.dto;

public class NotificationNoteSummaryDto {
	
	private Long notificationId;

	private String name;
	
	private String farmHouseName;
	
	private String noteTitle;
	
	private String message;
	
	private String notitype;
	
	private String labelNotiValue;
	
	private String status;
	
	private Long score;
	
	private String remarks;
	
	private String dateOfNotification;
	
	

	public NotificationNoteSummaryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getNotificationId() {
		return notificationId;
	}

	public String getName() {
		return name;
	}

	public String getFarmHouseName() {
		return farmHouseName;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public String getMessage() {
		return message;
	}

	public String getNotitype() {
		return notitype;
	}

	public String getStatus() {
		return status;
	}

	public Long getScore() {
		return score;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getDateOfNotification() {
		return dateOfNotification;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFarmHouseName(String farmHouseName) {
		this.farmHouseName = farmHouseName;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setNotitype(String notitype) {
		this.notitype = notitype;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setDateOfNotification(String dateOfNotification) {
		this.dateOfNotification = dateOfNotification;
	}

	public String getLabelNotiValue() {
		return labelNotiValue;
	}

	public void setLabelNotiValue(String labelNotiValue) {
		this.labelNotiValue = labelNotiValue;
	}
	

}
