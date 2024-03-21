package pt05.com.sg.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.dto.FarmHouseDto;
import pt05.com.sg.data.dto.NoteDto;
import pt05.com.sg.data.dto.TaskDto;
import pt05.com.sg.data.entity.Note;
import pt05.com.sg.data.entity.RuleCodeValue;
import pt05.com.sg.data.entity.UserNoteRule;
import pt05.com.sg.data.entity.Task;
import pt05.com.sg.data.entity.User;
import pt05.com.sg.data.entity.FarmHouse;
import pt05.com.sg.data.repository.FarmHouseRepository;
import pt05.com.sg.data.repository.NoteRepository;
import pt05.com.sg.data.repository.RuleCodeValueRepository;
import pt05.com.sg.data.repository.UserNoteRuleRepository;
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
	
	@Autowired
	private UserNoteRuleRepository userNoteRuleRepository;
	
	@Autowired
	private RuleCodeValueRepository ruleCodeValueRepository;
	
	
	
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
					dto.setUserId(n.getUser().getUserId());
					
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


@Override
public Map<String, String> addOrUpdate(NoteDto noteDto) {
	Map<String,String> responseMessage=new HashMap<String,String>();
	String message="";
	try {
	Optional<FarmHouse> farmHouseDb=this.farmHouseRepository.findByFarmHouseId(noteDto.getFarmHouseId());
	Optional<User> userOptional=this.userRepository.findByUserId(noteDto.getUserId());
	if(farmHouseDb.isPresent() && farmHouseDb!=null && noteDto.getNoteId() == null) {
		// to create 
		log.info("To create the Note and User Note");
		Note note=new Note();
		note.setUser(userOptional.get());
		note.setFarmHouse(farmHouseDb.get());
		note.setNoteTitle(noteDto.getNoteTitle());
		note.setNoteType(noteDto.getNoteType());
		note.setStatus(noteDto.getStatus());
		note.setRemarks(noteDto.getRemarks());
		note.setCreatedBy(userOptional.get().getName());
		note.setCreatedDate(new Date());
		note.setLastUpdatedBy(userOptional.get().getName());
		note.setLastUpdatedDate(new Date());
		
		
		Note noteDb=this.noteRepository.save(note);
		
		log.info("Weather Code value id:"+noteDto.getWeatherCodeValueId());
		
		List<Long> ruleCodeValueIds=new ArrayList<Long>();
		ruleCodeValueIds.add(noteDto.getWeatherCodeValueId());
		ruleCodeValueIds.add(noteDto.getWaterConsumptionCodeValueId());
		ruleCodeValueIds.add(noteDto.getTreatmentCodeValueId());
		ruleCodeValueIds.add(noteDto.getWormCountCodeValueId());
		
		for(Long rcv:ruleCodeValueIds) {
			log.info("Code Value ID "+ rcv);
		}
		
		
		if(noteDb!=null) {
			
			
			for(Long rcv:ruleCodeValueIds) {
				
			UserNoteRule userNoteRule=new UserNoteRule();
			
			//userNoteRule.setNoteRuleId(noteDb.getNoteId());
			//log.info("To create teh user note rule"+ rcv);
			RuleCodeValue rcvDb=this.ruleCodeValueRepository.findByRuleCodeValueId(rcv).get();
			
			log.info("To create the user note rule"+ rcvDb.getRuleCodeValueId());
			
			userNoteRule.setRuleValue(rcvDb.getCodeValue());
			//userNoteRule.setru(rcvDb.getRuleCodeValueId());
			userNoteRule.setRuleCodeValue(rcvDb);
			userNoteRule.setNote(noteDb);
			userNoteRule.setRemarks("Remarks");
			
			userNoteRule.setCreatedBy(userOptional.get().getName());
			userNoteRule.setCreatedDate(new Date());
			userNoteRule.setLastUpdatedBy(userOptional.get().getName());
			userNoteRule.setLastUpdatedDate(new Date());
			
			UserNoteRule userNoteRuleDb=this.userNoteRuleRepository.save(userNoteRule);
			
				if(userNoteRuleDb!=null) {
					//to create the user note rule
					message="User Rule Note has been Added Successfully";
					responseMessage.put("status", "Success");
					responseMessage.put("message",message);
				}else {
					log.info("User Note Rule failed to created");
				}
			
			
			}
			
		}
		
	
	}else{
		log.info("User and FarmHouse not exist, User Rule Note cannot be creatd without a valid user");
		message="User and FarmHouse must exist to create User Rule Note";
		responseMessage.put("status", "Failed");
		responseMessage.put("message",message);
	}
	}catch(Exception e) {
		log.info("System Exception "+e.getStackTrace());
		responseMessage.put("status", "Failed");
		message=e.getMessage();
		responseMessage.put("message",e.getMessage());
	}
	
	return null;
}

}
