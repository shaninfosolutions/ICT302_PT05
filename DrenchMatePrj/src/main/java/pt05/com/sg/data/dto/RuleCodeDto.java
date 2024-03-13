package pt05.com.sg.data.dto;

import java.util.List;


public class RuleCodeDto {
	
	private Long ruleCodeId;
	
	private String code;
	
	private String codeDesc;
	
	private String remarks;
	
	private List<RuleCodeValueDto> ruleCodeValueList;

	public RuleCodeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getRuleCodeId() {
		return ruleCodeId;
	}

	public void setRuleCodeId(Long ruleCodeId) {
		this.ruleCodeId = ruleCodeId;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<RuleCodeValueDto> getRuleCodeValueList() {
		return ruleCodeValueList;
	}

	public void setRuleCodeValueList(List<RuleCodeValueDto> ruleCodeValueList) {
		this.ruleCodeValueList = ruleCodeValueList;
	}
	

}
