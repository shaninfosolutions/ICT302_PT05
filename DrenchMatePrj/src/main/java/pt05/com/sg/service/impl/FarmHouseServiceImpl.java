package pt05.com.sg.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.dto.FarmHouseDto;
import pt05.com.sg.data.dto.UserDto;
import pt05.com.sg.data.dto.AnimalDto;


import pt05.com.sg.data.entity.Animal;
import pt05.com.sg.data.entity.FarmHouse;
import pt05.com.sg.data.entity.User;
import pt05.com.sg.data.repository.FarmHouseRepository;
import pt05.com.sg.data.repository.UserRepository;
import pt05.com.sg.service.FarmHouseService;
import pt05.com.sg.util.FirmHouseHelper;
import pt05.com.sg.util.UserHelper;

@Service
public class FarmHouseServiceImpl implements FarmHouseService{
	
	private static final Logger log = LoggerFactory.getLogger(FarmHouseServiceImpl.class);

	
	@Autowired
	private FarmHouseRepository farmHouseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Map<String,List<FarmHouseDto>> getList() {
		Map<String,List<FarmHouseDto>> responseMessage=new HashMap<String,List<FarmHouseDto>>();
		
		List<FarmHouseDto> dtolist=new ArrayList<>();
		List<FarmHouse> list=(List<FarmHouse>) this.farmHouseRepository.findAll();
		
		if(list!=null && list.size()>0) {
			for(FarmHouse farmhouse:list) {
				FarmHouseDto dto=FirmHouseHelper.mapFarmHouseDto(farmhouse);
				dtolist.add(dto);
				responseMessage.put("data", dtolist);
			}
		}
		else {
			responseMessage.put("data", null);
			
		}
		
		//return (List<FarmHouse>) this.farmHouseRepository.findAll();
		
		return responseMessage;
	}
	
	public Map<String,String> addOrUpdate(FarmHouseDto farmHouse) {
		Map<String,String> responseMessage=new HashMap<String,String>();
		String message="";
		
		Optional<User> userOptional=this.userRepository.findByUserId(farmHouse.getUserId());
		log.info("Farm House User ID: " +farmHouse.getUserId());
		try {
		if(userOptional.isPresent() && userOptional.get()!=null && farmHouse.getFarmHouseId()==null) {
			
			log.info("Farm House Exist to Added " +farmHouse.getFarmHouseId());
			User userDb=userOptional.get();
			
			FarmHouse farmHouseDb = new FarmHouse();
			farmHouseDb.setFarmHouseName(farmHouse.getFarmHouseName());
			farmHouseDb.setLocation(farmHouse.getLocation());
			farmHouseDb.setCapacity(farmHouse.getCapacity());
			farmHouseDb.setRemarks(farmHouse.getRemarks());
			farmHouseDb.setUser(userDb);
			farmHouseDb.setCreatedBy(farmHouse.getCreatedBy());
			farmHouseDb.setCreatedDate(new Date());
			farmHouseDb.setLastUpdatedBy(farmHouse.getLastUpdatedBy());
			farmHouseDb.setLastUpdatedDate(new Date());
			
			
			FarmHouse saveFarmHouse= this.farmHouseRepository.save(farmHouseDb);
			
			if(saveFarmHouse!=null && saveFarmHouse.getFarmHouseId()>0) {
				message="Firmhouse hased been Added Successfully";
				responseMessage.put("status", "Success");
				responseMessage.put("message",message);
			}
		}else if (userOptional.isPresent() && userOptional.get()!=null && farmHouse.getFarmHouseId()!=null){
			log.info("Farm House Exist to update " +farmHouse.getFarmHouseId());
			FarmHouse farmHouseDb=this.farmHouseRepository.findByFarmHouseId(farmHouse.getFarmHouseId()).get();
			if(farmHouseDb!=null) {
				User userDb=userOptional.get();
				farmHouseDb.setFarmHouseName(farmHouse.getFarmHouseName());
				farmHouseDb.setLocation(farmHouse.getLocation());
				farmHouseDb.setCapacity(farmHouse.getCapacity());
				farmHouseDb.setRemarks(farmHouse.getRemarks());
				farmHouseDb.setUser(userDb);
				farmHouseDb.setLastUpdatedBy(farmHouse.getLastUpdatedBy());
				farmHouseDb.setLastUpdatedDate(new Date());
				
				FarmHouse saveFarmHouse= this.farmHouseRepository.save(farmHouseDb);
				
				if(saveFarmHouse!=null && saveFarmHouse.getFarmHouseId()>0) {
					message="Firmhouse hased been Updated Successfully";
					responseMessage.put("status", "Success");
					responseMessage.put("message",message);
				}
			}
			
			
		}else {
			log.info("User not exist, Farm House cannot be creatd without a valid user");
			message="User must exist to create Farmhouse";
			responseMessage.put("status", "Failed");
			responseMessage.put("message",message);
		}
		}catch(Exception e) {
			log.info("Farm House Exception ");
			responseMessage.put("status", "Failed");
			message=e.getMessage();
			responseMessage.put("message",e.getMessage());
			
		}
		return responseMessage;
	}

	@Override
	public FarmHouseDto getFarmHouseByFarmHouseId(Long farmHouseId) {
		Optional<FarmHouse> farmHouse= this.farmHouseRepository.findByFarmHouseId(farmHouseId);
		FarmHouseDto farmHouseDto=null;
		try {
			if(farmHouse.isPresent() && farmHouse.get()!=null ) {
				
				farmHouseDto=FirmHouseHelper.mapFarmHouseDto(farmHouse.get());
			}else {
				log.info("Farmhouse not exist in the System!!!!");
				farmHouseDto=null;
			}
			
		}catch(Exception e) {
			log.info("System Exception");
		}
		
		return farmHouseDto;
	}
	
	@Override
	public Map<String,String> getFarmHouseMapByUserId(Long userId){
		HashMap<String,String> map=null;
		Optional<List<FarmHouse>> farmHouse=this.farmHouseRepository.findByUserId(userId);
		try {
			log.info("farmHouse.isPresent() " +farmHouse.isPresent());
			if(farmHouse.isPresent() && farmHouse.get().size()>0) {
				map=new HashMap<String,String>();
				List<FarmHouse> farmHouseDb=farmHouse.get();
				for(FarmHouse fh:farmHouseDb) {
					map.put(String.valueOf(fh.getFarmHouseId()), fh.getFarmHouseName());
					
				}
			}else {
				log.info("Farmhouse not exist in the System!!!!");
				map=null;
			}
			
		}catch(Exception e) {
			log.info("System Exception");
		}
		
		return map;
	}

	@Override
	public List<FarmHouseDto> getFarmHouseListByUserId(Long userId) {
		
		Optional<List<FarmHouse>> farmHouse=this.farmHouseRepository.findByUserId(userId);
		List<FarmHouseDto> farmHouseDtolist=null;
		try {
			log.info("farmHouse.isPresent() " +farmHouse.isPresent());
			if(farmHouse.isPresent() && farmHouse.get().size()>0) {
				log.info("Farmhouse exist in the System!!!!");
				List<FarmHouse> farmHouseDb=farmHouse.get();
				
				farmHouseDtolist=new ArrayList<>();
				
				for(FarmHouse fh:farmHouseDb) {
					
					farmHouseDtolist.add(FirmHouseHelper.mapFarmHouseDto(fh));
				}
				
			}else {
				log.info("Farmhouse not exist in the System!!!!");
			}
		
		}
		catch(Exception e) {
			log.info("System Exception");
		}
		return farmHouseDtolist;
	}
	
	
	public Map<String,String>  deleteFarmhouseById(Long farmhouseById){
		
		Optional<FarmHouse> farmHouseOptional=this.farmHouseRepository.findByFarmHouseId(farmhouseById);
		String message="";
		Map<String,String> responseMessage=new HashMap<String,String>();
		try {
			if(farmHouseOptional.isPresent()) {
				
				this.farmHouseRepository.delete(farmHouseOptional.get());
				message="Deleted Farmhouse Successfully";
				responseMessage.put("status", "Success");
				responseMessage.put("message",message);
				
			}else {
				message="Farmhouse not exist to delete";
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
