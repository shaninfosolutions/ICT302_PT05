package pt05.com.sg.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.dto.AnimalDto;
import pt05.com.sg.data.entity.Animal;
import pt05.com.sg.data.entity.FarmHouse;
import pt05.com.sg.data.entity.User;
import pt05.com.sg.data.repository.AnimalRepository;
import pt05.com.sg.data.repository.FarmHouseRepository;
import pt05.com.sg.service.AnimalService;
import pt05.com.sg.util.AnimalHelper;

@Service
public class AnimalServiceImpl implements AnimalService{
	
	private static final Logger log = LoggerFactory.getLogger(AnimalServiceImpl.class);
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private FarmHouseRepository farmHouseRepository;
	
	
	
	public List<Animal> getList() {
		return (List<Animal>) this.animalRepository.findAll();
	}
	
	public Map<String,String> addOrUpdate(AnimalDto animal) {
		
		Map<String,String> responseMessage=new HashMap<String,String>();
		String message="";
		try {
			Animal animalDb=new Animal();
			animalDb.setName(animal.getName());
			animalDb.setAnimalType(animal.getAnimalType());
			animalDb.setAge(animal.getAge());
			animalDb.setCreatedBy(animal.getCreatedBy());
			animalDb.setCreatedDate(new Date());
			animalDb.setLastUpdatedBy(animal.getLastUpdatedBy());
			animalDb.setLastUpdatedDate(new Date());
			
			FarmHouse farmHouse=farmHouseRepository.findByFarmHouseId(animal.getFarmHouseId()).get();
			animalDb.setFarmHouse(farmHouse);
			
			Animal saveAnimal=this.animalRepository.save(animalDb);
			
			if(saveAnimal!=null && saveAnimal.getAnimalId()>0) {
				message="Animal has been Added/Updated Successfully";
				responseMessage.put("status", "Success");
				responseMessage.put("message",message);
			}else {
				message="Failed to Add/Update Animal";
				responseMessage.put("status", "Failed");
				responseMessage.put("message",message);
			}
			
		}catch(Exception e) {
			log.info("Animal Exception ");
			responseMessage.put("status", "Failed");
			message=e.getMessage();
			responseMessage.put("message",e.getMessage());
		}
		
		return responseMessage;
	}
	
	public AnimalDto findAnimalByAnimalId(Long animalId) {
		Optional<Animal> animal=this.animalRepository.findByAnimalId(animalId);
		
		if(animal.isPresent()) {
			return AnimalHelper.mapFarmHouseDto(animal.get());
		}
	
		return null;
	}
	
	public List<AnimalDto> findAnimalsByFarmHouseId(Long farmHouseId) {
		Optional<List<Animal>> list=this.animalRepository.findAnimalsByFarmHouseId(farmHouseId);
		
		if(list.isPresent()) {
			List<AnimalDto> dtoList=new ArrayList<>();
			
			for(Animal animal: list.get()) {
				dtoList.add(AnimalHelper.mapFarmHouseDto(animal));
			}
			
			return dtoList;
		}
		
		return null;
	
	}
	
	public Map<String,String>  deleteAnimalById(Long animalId){
		
		Optional<Animal> animalOptional=this.animalRepository.findByAnimalId(animalId);
		String message="";
		Map<String,String> responseMessage=new HashMap<String,String>();
		try {
			if(animalOptional.isPresent()) {
				
				this.animalRepository.delete(animalOptional.get());
				message="Deleted Animal Successfully";
				responseMessage.put("status", "Success");
				responseMessage.put("message",message);
				
			}else {
				message="Animal not exist to delete";
				responseMessage.put("status", "Failed");
				responseMessage.put("message",message);
			}
			
		}catch(Exception e) {
			responseMessage.put("status", "Failed");
			message=e.getMessage();
			responseMessage.put("message",e.getMessage());
		}
		
		return responseMessage;
	}
	

}
