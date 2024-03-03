package pt05.com.sg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.entity.Note;
import pt05.com.sg.data.repository.NoteRepository;
import pt05.com.sg.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService{
	
	@Autowired
	private NoteRepository noteRepository;
	
	public List<Note> getList() {
		return (List<Note>) this.noteRepository.findAll();
	}
	
	public Note addOrUpdate(Note note) {
		return this.noteRepository.save(note);
	}

}
