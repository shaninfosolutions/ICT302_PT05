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
@Table(name = "TB_PARTNER")
public class Partner extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 365206671372490207L;
	
	@Id
	@GeneratedValue(generator="SEQ_PARTNER_ID",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="SEQ_PARTNER_ID",sequenceName="SEQ_PARTNER_ID", allocationSize=1)
	@Column(name = "PartnerId")
	private long PartnerId;
	
	@ManyToOne
	@JoinColumn(name="PartnerFromId", nullable=false)
	private User partnerFrom;
	
	
	@ManyToOne
	@JoinColumn(name="PartnerToId", nullable=false)
	private User partnerTo;
	
	
	@Column(name = "Acceptance")
	private String acceptance;
	

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

	public Partner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getPartnerId() {
		return PartnerId;
	}

	public void setPartnerId(long partnerId) {
		PartnerId = partnerId;
	}

	public User getPartnerFrom() {
		return partnerFrom;
	}

	public void setPartnerFrom(User partnerFrom) {
		this.partnerFrom = partnerFrom;
	}

	public User getPartnerTo() {
		return partnerTo;
	}

	public void setPartnerTo(User partnerTo) {
		this.partnerTo = partnerTo;
	}

	public String getAcceptance() {
		return acceptance;
	}

	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
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
		return "Partner [PartnerId=" + PartnerId + ", partnerFrom=" + partnerFrom + ", partnerTo=" + partnerTo
				+ ", acceptance=" + acceptance + ", verNo=" + verNo + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}
	

}
