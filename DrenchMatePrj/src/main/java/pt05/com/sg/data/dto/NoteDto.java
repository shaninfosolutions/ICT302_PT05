package pt05.com.sg.data.dto;


public class NoteDto {
	
	private Long noteId;
	
	private UserDto userDto;
	
	private FarmHouseDto farmHouseDto;
	
	private Long farmHouseId;
	
	private String farmHouseName;
	
	private Long userId;
	
	private String noteTitle;
	

	private String noteType;
	

	private String status;
	

	private String remarks;
	
	private Long weatherCodeValueId;

	private Long wormCountCodeValueId;
	
	private Long treatmentCodeValueId;
	
	private Long waterConsumptionCodeValueId;


	public NoteDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getNoteId() {
		return noteId;
	}


	public void setNoteId(Long noteId) {
		this.noteId = noteId;
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


	public String getNoteTitle() {
		return noteTitle;
	}


	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}


	public String getNoteType() {
		return noteType;
	}


	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}


	public String getStatus() {
		return status;
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


	public Long getWeatherCodeValueId() {
		return weatherCodeValueId;
	}


	public void setWeatherCodeValueId(Long weatherCodeValueId) {
		this.weatherCodeValueId = weatherCodeValueId;
	}


	public Long getWormCountCodeValueId() {
		return wormCountCodeValueId;
	}


	public void setWormCountCodeValueId(Long wormCountCodeValueId) {
		this.wormCountCodeValueId = wormCountCodeValueId;
	}


	public Long getTreatmentCodeValueId() {
		return treatmentCodeValueId;
	}


	public void setTreatmentCodeValueId(Long treatmentCodeValueId) {
		this.treatmentCodeValueId = treatmentCodeValueId;
	}


	public Long getWaterConsumptionCodeValueId() {
		return waterConsumptionCodeValueId;
	}


	public void setWaterConsumptionCodeValueId(Long waterConsumptionCodeValueId) {
		this.waterConsumptionCodeValueId = waterConsumptionCodeValueId;
	}


	
	
	

}
