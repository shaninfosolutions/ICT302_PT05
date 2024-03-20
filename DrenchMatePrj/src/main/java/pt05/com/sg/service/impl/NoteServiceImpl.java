package pt05.com.sg.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.dto.FarmHouseDto;
import pt05.com.sg.data.dto.NoteDto;
import pt05.com.sg.data.dto.TaskDto;
import pt05.com.sg.data.entity.Note;
import pt05.com.sg.data.entity.Task;
import pt05.com.sg.data.entity.FarmHouse;
import pt05.com.sg.data.repository.FarmHouseRepository;
import pt05.com.sg.data.repository.NoteRepository;
import pt05.com.sg.data.repository.UserRepository;
import pt05.com.sg.service.NoteService;
import pt05.com.sg.util.NoteHelper;

@Service
public class NoteServiceImpl implements NoteService{
	
	private static final Logger log = LoggerFactory.getLogger(NoteServiceImpl.class);
	
	
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FarmHouseRepository farmHouseRepository;
	
	
	public List<NoteDto> getList(Long userId){
		
		Optional<List<Note>> noteList=this.noteRepository.findByUserId(userId);
		List<NoteDto> noteDtolist=null;
		try {
			
			if(noteList.isPresent() && noteList!=null) {
				noteDtolist= new ArrayList<>();
				
				for(Note n: noteList.get()) {
					NoteDto dto = new NoteDto();
					
					dto.setNoteId(n.getNoteId());
					dto.setNoteTitle(n.getNoteTitle());
					dto.setNoteType(n.getNoteType());
					dto.setRemarks(n.getRemarks());
					dto.setStatus(n.getStatus());
					log.info("Note Farm House ID : " + n.getFarmHouse().getFarmHouseId());
					FarmHouse fhdb=this.farmHouseRepository.findByFarmHouseId(n.getFarmHouse().getFarmHouseId()).get();
					
					FarmHouseDto fhdto=new FarmHouseDto();
					fhdto.setFarmHouseId(fhdb.getFarmHouseId());
					fhdto.setFarmHouseName(fhdb.getFarmHouseName());
					fhdto.setCapacity(fhdb.getCapacity());
					fhdto.setLocation(fhdb.getLocation());
					fhdto.setRemarks(fhdb.getRemarks());
					dto.setFarmHouseDto(fhdto);
					dto.setFarmHouseName(n.getFarmHouse().getFarmHouseName());
					dto.setUserId(String.valueOf(n.getUser().getUserId()));
					
					noteDtolist.add(dto);
				}
				
			}else {
				noteDtolist=null;
			}
			
		}catch(Exception e) {
			log.info("System Exception");
		}
		return noteDtolist;
		
	}
	
	
public NoteDto getTaskByTaskId(Long noteId) {
		
		Optional<Note> note=this.noteRepository.findByNoteId(noteId);
		NoteDto noteDto=null;
		try {
			
			if(note.isPresent() && note.get()!=null) {
				noteDto=NoteHelper.mapNoteDto(note.get());
				
			}else {
				log.info("Note not exist in the System!!!!");
				noteDto=null;
			}
			
		}catch(Exception e) {
			log.info("System Exception");
		}
		
		return noteDto;
		
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
	
public Map<String,String>  deleteNoteById(Long noteId){
		
		Optional<Note> noteOptional=this.noteRepository.findByNoteId(noteId);
		String message="";
		Map<String,String> responseMessage=new HashMap<String,String>();
		try {
			if(noteOptional.isPresent() && noteOptional!=null) {
				
				this.noteRepository.delete(noteOptional.get());
				message="Deleted Noted Successfully";
				responseMessage.put("status", "Success");
				responseMessage.put("message",message);
				
			}else {
				message="Note not exist to delete";
				responseMessage.put("status", "Failed");
				responseMessage.put("message",message);
			}
			
		}catch(Exception e) {
			responseMessage.put("status", "Failed");
			message=e.getMessage();
			responseMessage.put("message",e.getMessage());
		}
		
		return responseMessage;
	}
	
	
	

}
