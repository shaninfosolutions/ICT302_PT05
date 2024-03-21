package pt05.com.sg.service;

import java.util.List;
import java.util.Map;

import pt05.com.sg.data.dto.NoteDto;

public interface NoteService {
	
	public List<NoteDto> getList(Long userId);
	
	public NoteDto getTaskByTaskId(Long noteId);
	
	public Map<String,String>  deleteNoteById(Long noteId);
	
	public Map<String,String> addOrUpdate(NoteDto noteDto);

}
