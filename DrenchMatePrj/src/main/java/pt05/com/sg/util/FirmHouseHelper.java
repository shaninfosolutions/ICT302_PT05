package pt05.com.sg.util;

import java.util.ArrayList;
import java.util.List;

import pt05.com.sg.data.dto.AnimalDto;
import pt05.com.sg.data.dto.FarmHouseDto;
import pt05.com.sg.data.dto.UserDto;
import pt05.com.sg.data.entity.Animal;
import pt05.com.sg.data.entity.FarmHouse;
import pt05.com.sg.data.entity.User;

public class FirmHouseHelper {
	
	public static FarmHouseDto mapFarmHouseDto(FarmHouse farmHouse) {
		
		FarmHouseDto fhdto=new FarmHouseDto();
		fhdto.setFarmHouseId(farmHouse.getFarmHouseId());
		fhdto.setFarmHouseName(farmHouse.getFarmHouseName());
		fhdto.setCapacity(farmHouse.getCapacity());
		fhdto.setLocation(farmHouse.getLocation());
		fhdto.setRemarks(farmHouse.getRemarks());
		
		
		User userDb=farmHouse.getUser();
		UserDto userdto=new UserDto();
		userdto.setName(userDb.getName());
		userdto.setEmail(userDb.getEmail());
		userdto.setDisplayName(userDb.getUserProfile().getDisplayName());
		
		fhdto.setUser(userdto);
		fhdto.setUserId(userDb.getUserId());
		
		List<AnimalDto> animalDtoList=new ArrayList<>();
		for(Animal animal:farmHouse.getAnimalList()) {
			AnimalDto animaldto=new AnimalDto();
			animaldto.setAnimalId(animal.getAnimalId());
			animaldto.setAnimalType(animal.getAnimalType());
			animaldto.setAge(animal.getAge());
			animaldto.setWeight(animal.getWeight());
			animaldto.setRemarks(animal.getRemarks());
			
			animalDtoList.add(animaldto);
		}
		
		fhdto.setAnimal(animalDtoList);
		fhdto.setMessage(farmHouse.getFarmHouseName()+": Found in the System");
		fhdto.setCreatedBy(farmHouse.getCreatedBy());
		fhdto.setLastUpdatedBy(farmHouse.getLastUpdatedBy());
		fhdto.setStatus("Success");
		
		return fhdto;
	}

}
