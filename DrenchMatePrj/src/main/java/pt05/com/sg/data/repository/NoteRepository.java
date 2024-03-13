package pt05.com.sg.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pt05.com.sg.data.entity.User;
import pt05.com.sg.data.entity.FarmHouse;
import pt05.com.sg.data.entity.Note;
@Repository
public interface NoteRepository extends CrudRepository<Note, Long>{
	
	 Optional<Note> findByNoteId(Long noteId);
	 
	 @Query("SELECT note FROM Note note WHERE note.user.userId = ?1")
	 Optional<List<Note> >findByUserId(Long userId);
	 
	 void deleteByNoteId(Long noteId);

}
