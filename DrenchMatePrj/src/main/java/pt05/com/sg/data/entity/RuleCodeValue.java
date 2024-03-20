package pt05.com.sg.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;


@Entity
@Table(name = "TB_RULE_CODE_VALUE")
public class RuleCodeValue extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5058244247037139978L;
	
	@Id
	@GeneratedValue(generator="SEQ_RULE_CODE_VALUE_ID",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="SEQ_RULE_CODE_VALUE_ID",sequenceName="SEQ_RULE_CODE_VALUE_ID", allocationSize=1)
	@Column(name = "RuleCodeValueId")
	
	
	private long ruleCodeValueId;
	
	@ManyToOne
	@JoinColumn(name="RuleCodeId", nullable=false)
	private RuleCode ruleCode;
	
	@Column(name = "Code")
	private String code;
	
	@Column(name = "CodeDesc")
	private String codeDesc;
	
	@Column(name = "CodeValue")
	private Long codeValue;
	
	@Column(name = "Remarks")
	private String remarks;
	
	
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

	public RuleCodeValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getRuleCodeValueId() {
		return ruleCodeValueId;
	}

	public void setRuleCodeValueId(long ruleCodeValueId) {
		this.ruleCodeValueId = ruleCodeValueId;
	}

	public RuleCode getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(RuleCode ruleCode) {
		this.ruleCode = ruleCode;
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

	

	
	

}
