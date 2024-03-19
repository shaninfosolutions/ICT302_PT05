package pt05.com.sg.util;

import pt05.com.sg.data.dto.FarmHouseDto;
import pt05.com.sg.data.dto.NoteDto;
import pt05.com.sg.data.entity.FarmHouse;
import pt05.com.sg.data.entity.Note;

public class NoteHelper {

	public static NoteDto mapNoteDto(Note note) {
		NoteDto dto=new NoteDto();
		dto.setNoteId(note.getNoteId());
		dto.setNoteTitle(note.getNoteTitle());
		dto.setNoteType(note.getNoteType());
		dto.setRemarks(note.getRemarks());
		dto.setStatus(note.getStatus());
		
		FarmHouse farmHouse=note.getFarmHouse();
		
		FarmHouseDto fhdto=new FarmHouseDto();
		fhdto.setFarmHouseId(farmHouse.getFarmHouseId());
		fhdto.setFarmHouseName(farmHouse.getFarmHouseName());
		fhdto.setCapacity(farmHouse.getCapacity());
		fhdto.setLocation(farmHouse.getLocation());
		fhdto.setRemarks(farmHouse.getRemarks());
		
		dto.setFarmHouseName(farmHouse.getFarmHouseName());
		dto.setFarmHouseId(String.valueOf(farmHouse.getFarmHouseId()) );
		
		
		
		dto.setFarmHouseDto(fhdto);
		
		return dto;
	}
}
