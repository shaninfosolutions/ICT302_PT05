package pt05.com.sg.data.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pt05.com.sg.data.entity.Animal;
import pt05.com.sg.data.entity.FarmHouse;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long>{
	
	 Optional<Animal> findByAnimalId(Long animalId);
	 
	 void deleteByAnimalId(Long animalId);
	
	 @Query("SELECT animal FROM Animal animal WHERE animal.farmHouse.farmHouseId = ?1")	 
	 Optional<List<Animal>> findAnimalsByFarmHouseId(Long farmHouseId);

}
