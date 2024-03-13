package pt05.com.sg.util;

import pt05.com.sg.data.dto.AnimalDto;
import pt05.com.sg.data.entity.Animal;


public class AnimalHelper {

	public static AnimalDto mapFarmHouseDto(Animal animal) {
		AnimalDto dto=new AnimalDto();
		dto.setAnimalId(animal.getAnimalId());
		dto.setAge(animal.getAge());
		dto.setAnimalType(animal.getAnimalType());
		dto.setRemarks(animal.getRemarks());
		dto.setFarmHouseId(animal.getFarmHouse().getFarmHouseId());
		dto.setFarmHouseName(animal.getFarmHouse().getFarmHouseName());
		return dto;
	}
}
