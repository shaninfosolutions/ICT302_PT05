package pt05.com.sg.service;

import java.util.List;
import java.util.Map;

import pt05.com.sg.data.dto.AnimalDto;
import pt05.com.sg.data.entity.Animal;

public interface AnimalService {

	public Map<String,List<AnimalDto>>getList();
	
	public Map<String,String> addOrUpdate(AnimalDto animal);
	
	public AnimalDto findAnimalByAnimalId(Long animalId);
	
	public List<AnimalDto> findAnimalsByFarmHouseId(Long farmHouseId);
	
	public Map<String,String>  deleteAnimalById(Long animalId);
}
