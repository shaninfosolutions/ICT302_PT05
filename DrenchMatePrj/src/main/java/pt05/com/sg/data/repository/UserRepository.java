package pt05.com.sg.data.repository;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pt05.com.sg.data.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	 Optional<User> findByEmail(String email);
	 
	 Optional<User> findByUserId(Long userId);
	 
}
