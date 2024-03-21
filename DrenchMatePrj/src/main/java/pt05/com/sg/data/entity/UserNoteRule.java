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
@Table(name = "TB_USER_NOTE_RULE")
public class UserNoteRule extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5693251662374872394L;
	
	@Id
	@GeneratedValue(generator="SEQ_USER_NOTE_RULE_ID",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="SEQ_USER_NOTE_RULE_ID",sequenceName="SEQ_USER_NOTE_RULE_ID", allocationSize=1)
	@Column(name = "NoteRuleId")
	private long noteRuleId;
	
	@ManyToOne
	@JoinColumn(name="NoteId")
	private Note note;
	
	//--to do list
	
	@Column(name = "RuleValue")
	private Long ruleValue;
	
	@Column(name = "Remarks")
	private String Remarks;
	
	@ManyToOne
	@JoinColumn(name="RuleCodeValueId", nullable=false)
	private RuleCodeValue ruleCodeValue;
	
	
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

	public UserNoteRule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getNoteRuleId() {
		return noteRuleId;
	}

	public void setNoteRuleId(long noteRuleId) {
		this.noteRuleId = noteRuleId;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
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

	public RuleCodeValue getRuleCodeValue() {
		return ruleCodeValue;
	}

	public void setRuleCodeValue(RuleCodeValue ruleCodeValue) {
		this.ruleCodeValue = ruleCodeValue;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	

}
