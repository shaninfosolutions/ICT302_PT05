package pt05.com.sg.data.dto;

import java.util.List;

public class FarmHouseDto {
	
	private Long userId;
	
	private UserDto user;
	
	private List<AnimalDto> animal;
	
	private Long farmHouseId;
	
	private String farmHouseName;
	
	private String location;
	
	private Long capacity;
	
	private String remarks;
	
	private String message;
	
	private String status;
	
	private String createdBy;
	
	private String lastUpdatedBy;

	public FarmHouseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public UserDto getUser() {
		return user;
	}



	public void setUser(UserDto user) {
		this.user = user;
	}


	public List<AnimalDto> getAnimal() {
		return animal;
	}



	public void setAnimal(List<AnimalDto> animal) {
		this.animal = animal;
	}



	public Long getFarmHouseId() {
		return farmHouseId;
	}



	public void setFarmHouseId(Long farmHouseId) {
		this.farmHouseId = farmHouseId;
	}



	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFarmHouseName() {
		return farmHouseName;
	}

	public void setFarmHouseName(String farmHouseName) {
		this.farmHouseName = farmHouseName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
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
	
	
	
}
