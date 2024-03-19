package pt05.com.sg.service;

import java.util.List;

import pt05.com.sg.data.dto.NoteDto;

public interface NoteService {
	
	public List<NoteDto> getList(Long userId);
	
	public NoteDto getTaskByTaskId(Long noteId);

}
