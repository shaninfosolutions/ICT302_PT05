package pt05.com.sg.data.dto;

public class EligibleUsersToNotifyDto {
	
	private Long userId;
	
	private String name;
	
	private Long farmHouseId;
	
	private String email;

	public EligibleUsersToNotifyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public EligibleUsersToNotifyDto(Long userId,String name,Long farmHouseId,String email) {
		super();
		this.userId = userId;
		this.name=name;
		this.farmHouseId = farmHouseId;
		this.email=email;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	

}
