package pt05.com.sg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pt05.com.sg.data.dto.NoteDto;
import pt05.com.sg.data.dto.TaskDto;
import pt05.com.sg.service.impl.NoteServiceImpl;
import pt05.com.sg.service.impl.TaskServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class NoteController {
	
	private static final Logger log = LoggerFactory.getLogger(NoteController.class);
	
	@Autowired
	private NoteServiceImpl noteServiceImpl;
	
	@GetMapping("/dm/notes/userid/{userId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<NoteDto>findAllNotes(@PathVariable("userId") Long userId) {
			log.info("Find All Notes by User ID :"+ userId);
	   	 return this.noteServiceImpl.getList(userId);
	}
	
	
	@GetMapping("/dm/notes/{noteId}")
	@ResponseStatus(value = HttpStatus.OK)
	public NoteDto findNoteById(
			@PathVariable("noteId") Long noteId){
		log.info("Get Note by Task ID :"+ noteId);
		return this.noteServiceImpl.getTaskByTaskId(noteId);
		
	
	}

}
