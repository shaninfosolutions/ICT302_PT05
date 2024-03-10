package pt05.com.sg.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pt05.com.sg.data.entity.FarmHouse;
import pt05.com.sg.data.entity.User;
@Repository
public interface FarmHouseRepository extends CrudRepository<FarmHouse, Long>{
	
	 Optional<FarmHouse> findByFarmHouseId(Long farmHouseId);
	 
	 @Query("SELECT farmhouse FROM FarmHouse farmhouse WHERE farmhouse.user.userId = ?1")
	 Optional<List<FarmHouse> >findByUserId(Long userId);
	 
	 void deleteByFarmHouseId(Long farmHouseId);

}
