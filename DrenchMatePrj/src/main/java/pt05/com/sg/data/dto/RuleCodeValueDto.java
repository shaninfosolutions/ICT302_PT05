package pt05.com.sg.data.dto;

public class RuleCodeValueDto {

private Long ruleCodeValueId;
	
	private RuleCodeDto ruleCodeDto;
	
	private String parentRuleCode;
	
	private String code;

	private String codeDesc;
	
	
	private Long codeValue;
	
	
	private String remarks;


	public RuleCodeValueDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getRuleCodeValueId() {
		return ruleCodeValueId;
	}


	public void setRuleCodeValueId(Long ruleCodeValueId) {
		this.ruleCodeValueId = ruleCodeValueId;
	}


	public RuleCodeDto getRuleCodeDto() {
		return ruleCodeDto;
	}


	public void setRuleCodeDto(RuleCodeDto ruleCodeDto) {
		this.ruleCodeDto = ruleCodeDto;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getCodeDesc() {
		return codeDesc;
	}


	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}


	public Long getCodeValue() {
		return codeValue;
	}


	public void setCodeValue(Long codeValue) {
		this.codeValue = codeValue;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getParentRuleCode() {
		return parentRuleCode;
	}


	public void setParentRuleCode(String parentRuleCode) {
		this.parentRuleCode = parentRuleCode;
	}


	
	
}
