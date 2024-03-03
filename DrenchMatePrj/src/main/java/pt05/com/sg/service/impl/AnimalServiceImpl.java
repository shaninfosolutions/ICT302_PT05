package pt05.com.sg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.entity.Animal;
import pt05.com.sg.data.entity.User;
import pt05.com.sg.data.repository.AnimalRepository;
import pt05.com.sg.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService{
	
	@Autowired
	private AnimalRepository animalRepository;
	
	
	public List<Animal> getList() {
		return (List<Animal>) this.animalRepository.findAll();
	}
	
	public Animal addOrUpdate(Animal animal) {
		return this.animalRepository.save(animal);
	}

}
