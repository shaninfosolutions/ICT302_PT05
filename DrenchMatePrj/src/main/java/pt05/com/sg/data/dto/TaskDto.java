package pt05.com.sg.data.dto;

public class TaskDto {
	
	private Long taskId;
	
	private UserDto userDto;
	
	private Long userId;
	
	private FarmHouseDto farmHouseDto;
	
	private Long farmHouseId;
	
	private String farmHouseName;
	
	private String taskTitle;
	
	private String taskType;
	
	private String startDate;
	
	private String endDate;
	
	private String remarks;
	
	private String status;

	public TaskDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public FarmHouseDto getFarmHouseDto() {
		return farmHouseDto;
	}

	public void setFarmHouseDto(FarmHouseDto farmHouseDto) {
		this.farmHouseDto = farmHouseDto;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFarmHouseId() {
		return farmHouseId;
	}

	public void setFarmHouseId(Long farmHouseId) {
		this.farmHouseId = farmHouseId;
	}

	public String getFarmHouseName() {
		return farmHouseName;
	}

	public void setFarmHouseName(String farmHouseName) {
		this.farmHouseName = farmHouseName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

}
