package pt05.com.sg.data.dto;

public class AnimalDto {
	
	private long animalId;
	
	private String animalType;
	
	private String name;
	
	private Long age;
	
	private Long weight;
	
	private String remarks;
	
	private String message;
	
	private String status;
	
	private Long farmHouseId;
	
	private String farmHouseName;
	
	private String createdBy;
	
	private String lastUpdatedBy;

	public AnimalDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(long animalId) {
		this.animalId = animalId;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
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

	
	
	

}
