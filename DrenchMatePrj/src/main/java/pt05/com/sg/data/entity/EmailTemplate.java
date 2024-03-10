package pt05.com.sg.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "TB_EMAIL_TEMPLATE")
public class EmailTemplate extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7423294549167337903L;

	
	@Id
	@GeneratedValue(generator="SEQ_EMAIL_TEMPLATE_ID",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="SEQ_EMAIL_TEMPLATE_ID",sequenceName="SEQ_EMAIL_TEMPLATE_ID", allocationSize=1)
	@Column(name = "EmailTemplateId")
	private long emailTemplateId;
	
	@Lob
	@Column(name = "EmailTemplate")
	private String emailTemplate;
	
	@Column(name = "TemplateName")
	private String templateName;
	
	@Column(name = "TemplateNumber")
	private Long templateNumber;
	
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

	public EmailTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getEmailTemplateId() {
		return emailTemplateId;
	}

	public void setEmailTemplateId(long emailTemplateId) {
		this.emailTemplateId = emailTemplateId;
	}

	public String getEmailTemplate() {
		return emailTemplate;
	}

	public void setEmailTemplate(String emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Long getTemplateNumber() {
		return templateNumber;
	}

	public void setTemplateNumber(Long templateNumber) {
		this.templateNumber = templateNumber;
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

	@Override
	public String toString() {
		return "EmailTemplate [emailTemplateId=" + emailTemplateId + ", emailTemplate=:::" +  ", templateName=" + templateName + ", templateNumber=" + templateNumber + ", verNo=" + verNo
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}
	
	
}
