package pt05.com.sg.data.dto;

public class NotiTaskSummaryDto {
	private Long notificationId;

	private String name;
	
	private String farmHouseName;
	
	private String taskTitle;
	
	private String message;
	
	private String notitype;
	
	private String status;
	
	private String startDate;
	
	private String endDate;
	
	private String labelDue;
	
	private String remarks;
	
	private String dateOfNotification;
	
	
	

	
	

	public NotiTaskSummaryDto() {
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

	public String getTaskTitle() {
		return taskTitle;
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

	public String getDateOfNotification() {
		return dateOfNotification;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getLabelDue() {
		return labelDue;
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

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
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

	public void setDateOfNotification(String dateOfNotification) {
		this.dateOfNotification = dateOfNotification;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setLabelDue(String labelDue) {
		this.labelDue = labelDue;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
