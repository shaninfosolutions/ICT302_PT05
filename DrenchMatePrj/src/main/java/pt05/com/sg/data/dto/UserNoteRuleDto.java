package pt05.com.sg.data.dto;



public class UserNoteRuleDto {
	
	private Long noteRuleId;
	
	private NoteDto noteDto;
	
	
	private Long ruleValue;
	

	private String Remarks; 
	
	public UserNoteRuleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getNoteRuleId() {
		return noteRuleId;
	}

	public void setNoteRuleId(Long noteRuleId) {
		this.noteRuleId = noteRuleId;
	}

	public NoteDto getNoteDto() {
		return noteDto;
	}

	public void setNoteDto(NoteDto noteDto) {
		this.noteDto = noteDto;
	}

	public Long getRuleValue() {
		return ruleValue;
	}

	public void setRuleValue(Long ruleValue) {
		this.ruleValue = ruleValue;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	
}
