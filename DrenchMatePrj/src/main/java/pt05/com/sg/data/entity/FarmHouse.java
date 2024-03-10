package pt05.com.sg.data.entity;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "TB_FARM_HOUSE")
public class FarmHouse extends Base{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5784542686326213831L;
	
	@Id
	@GeneratedValue(generator="SEQ_FARM_HOUSE_ID",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="SEQ_FARM_HOUSE_ID",sequenceName="SEQ_FARM_HOUSE_ID", allocationSize=1)
	@Column(name = "FarmHouseId")
	private long farmHouseId;
	
	
	@ManyToOne
	@JoinColumn(name="UserId", nullable=false)
	private User user;
	
	
	@OneToMany(mappedBy = "farmHouse")
	private List<Animal> animalList=new ArrayList<>();
	
	
	@Column(name = "FarmHouseName")
	private String farmHouseName;
	
	@Column(name = "Location")
	private String location;
	
	@Column(name = "Capacity")
	private Long capacity;
	
	
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

	public FarmHouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getFarmHouseId() {
		return farmHouseId;
	}

	public void setFarmHouseId(long farmHouseId) {
		this.farmHouseId = farmHouseId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFarmHouseName() {
		return farmHouseName;
	}

	public void setFarmHouseName(String farmHouseName) {
		this.farmHouseName = farmHouseName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<Animal> getAnimalList() {
		return animalList;
	}

	public void setAnimalList(List<Animal> animalList) {
		this.animalList = animalList;
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
