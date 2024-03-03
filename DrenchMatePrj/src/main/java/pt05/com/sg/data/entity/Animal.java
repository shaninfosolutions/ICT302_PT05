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
@Table(name = "TB_ANIMAL")
public class Animal extends Base{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4151655563800928269L;
	
	
	@Id
	@GeneratedValue(generator="SEQ_ANIMAL_ID",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="SEQ_ANIMAL_ID",sequenceName="SEQ_ANIMAL_ID", allocationSize=1)
	@Column(name = "AnimalId")
	private long animalId;
	
	
	@ManyToOne
	@JoinColumn(name="FarmHouseId")
	private FarmHouse farmHouse;
	
	@Column(name = "AnimalType")
	private String animalType;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Age")
	private Long age;
	
	@Column(name = "Weight")
	private Long weight;
	
	
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

	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(long animalId) {
		this.animalId = animalId;
	}

	public FarmHouse getFarmHouse() {
		return farmHouse;
	}

	public void setFarmHouse(FarmHouse farmHouse) {
		this.farmHouse = farmHouse;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
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
