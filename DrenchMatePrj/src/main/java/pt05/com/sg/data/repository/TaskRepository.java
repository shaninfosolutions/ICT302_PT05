package pt05.com.sg.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pt05.com.sg.data.entity.Task;
@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{
	
	 @Query("SELECT task FROM Task task WHERE task.user.userId = ?1")
	 Optional<List<Task> >findByUserId(Long userId);

}
