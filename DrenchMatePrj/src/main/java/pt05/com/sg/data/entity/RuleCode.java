package pt05.com.sg.data.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;


@Entity
@Table(name = "TB_RULE_CODE")
public class RuleCode extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7656567790829888067L;

	@Id
	@GeneratedValue(generator="SEQ_RULE_CODE_ID",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="SEQ_RULE_CODE_ID",sequenceName="SEQ_RULE_CODE_ID", allocationSize=1)
	@Column(name = "RuleCodeId")
	private long ruleCodeId;
	
	@Column(name = "Code")
	private String code;
	
	@Column(name = "CodeDesc")
	private String codeDesc;
	
	@Column(name = "Remarks")
	private String remarks;
	
	@OneToMany(mappedBy = "ruleCode", cascade = CascadeType.ALL)
    private List<RuleCodeValue> ruleCodeValue;
	
	@Version
	@Column(name = "VerNo")
	private long verNo;
	
	@Column(name = "CreatedDate")
	private Date createdDate;
	
	@Column(name = "CreatedBy")
	private String createdBy;
	
	@Column(name = "LastUpdatedDate")
	private Date lastUpdatedDate;
	
	@Column(name = "LastedUpdatedBy")
	private String lastUpdatedBy;

	public RuleCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getRuleCodeId() {
		return ruleCodeId;
	}

	public void setRuleCodeId(long ruleCodeId) {
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

	public long getVerNo() {
		return verNo;
	}

	public void setVerNo(long verNo) {
		this.verNo = verNo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public List<RuleCodeValue> getRuleCodeValue() {
		return ruleCodeValue;
	}

	public void setRuleCodeValue(List<RuleCodeValue> ruleCodeValue) {
		this.ruleCodeValue = ruleCodeValue;
	}

	
	
	
}
