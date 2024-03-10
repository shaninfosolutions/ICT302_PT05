package pt05.com.sg.service;

import java.util.List;
import java.util.Map;

import pt05.com.sg.data.dto.FarmHouseDto;
import pt05.com.sg.data.entity.FarmHouse;

public interface FarmHouseService {
	
	public List<FarmHouse> getList() ;
	
	public Map<String,String> addOrUpdate(FarmHouseDto farmHouse);
	
	public FarmHouseDto getFarmHouseByFarmHouseId(Long farmHouseId);
	
	public List<FarmHouseDto> getFarmHouseListByUserId(Long userId);
	
	public Map<String,String>  deleteFarmhouseById(Long farmhouseById);
	
	
	
	

}
