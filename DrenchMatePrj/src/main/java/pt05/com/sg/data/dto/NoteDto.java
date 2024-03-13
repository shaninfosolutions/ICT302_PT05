package pt05.com.sg.data.dto;


public class NoteDto {
	
	private Long noteId;
	
	private UserDto userDto;
	
	private FarmHouseDto farmHouseDto;
	
	private String noteTitle;
	

	private String noteType;
	

	private String status;
	

	private String remarks;


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
	
	

}
