package pt05.com.sg.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.entity.Note;
import pt05.com.sg.data.repository.NoteRepository;
import pt05.com.sg.data.repository.UserRepository;
import pt05.com.sg.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService{
	
	private static final Logger log = LoggerFactory.getLogger(NoteServiceImpl.class);
	
	
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Note> getList() {
		return (List<Note>) this.noteRepository.findAll();
	}
	
	public Map<String,String> addOrUpdate(Note note) {
		Map<String,String> responseMessage=new HashMap<String,String>();
		String message="";
		try {
			
		}catch(Exception e) {
			log.info("Animal Exception ");
			responseMessage.put("status", "Failed");
			message=e.getMessage();
			responseMessage.put("message",e.getMessage());
		}
		
		return responseMessage;
		
	}
	
	

}
