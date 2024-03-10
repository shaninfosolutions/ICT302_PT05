package pt05.com.sg.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pt05.com.sg.data.entity.User;
import pt05.com.sg.data.entity.Note;
@Repository
public interface NoteRepository extends CrudRepository<Note, Long>{
	
	// @Query("SELECT farmhouse FROM FarmHouse farmhouse WHERE farmhouse.user.userId = ?1")
	 //Optional<List<User> >findUsersToNotify(Long );

}
