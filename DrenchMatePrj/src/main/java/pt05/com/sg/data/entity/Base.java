package pt05.com.sg.data.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Version;

public abstract class Base implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected long verNo;
	
	protected Date createdDate;
	
	protected String createdBy;
	
	protected Date lastUpdatedDate;
	
	protected String lastUpdatedBy;

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
