package pt05.com.sg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pt05.com.sg.data.dto.FarmHouseDto;
import pt05.com.sg.data.entity.FarmHouse;
import pt05.com.sg.data.entity.User;
import pt05.com.sg.service.impl.FarmHouseServiceImpl;
import pt05.com.sg.service.impl.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class FarmHouseController {
	
	private static final Logger log = LoggerFactory.getLogger(FarmHouseController.class);
	
	@Autowired
    private FarmHouseServiceImpl farmHouseServiceImpl;
	
	@GetMapping("/dm/farmhouses")
	public Map<String,List<FarmHouseDto>> findAllFarmHouses() {
    	 return this.farmHouseServiceImpl.getList();
	}
	
	@PostMapping("/dm/farmhouse/add")
	@ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Map<String,String>> addNewFirmhouse
    	(@RequestHeader Map<String, String> headers,@RequestBody FarmHouseDto farmHouseDto) {
		
		try {
			Map<String,String> responseMap=this.farmHouseServiceImpl.addOrUpdate(farmHouseDto);
			return ResponseEntity.status(HttpStatus.OK).body(responseMap);
		 
		}catch(Exception e) {
			Map<String,String> responseMap=new HashMap<String,String>();
			responseMap.put("status", "Failed");
			responseMap.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
		}
	}
	
	
	@GetMapping("/dm/farmhouses/userid")
	@ResponseStatus(value = HttpStatus.OK)
	public List<FarmHouseDto> findFarmHouseByUserId(@RequestParam("userId") Long userId){
		log.info("getfarmhouseId by User ID :"+ userId);
		return this.farmHouseServiceImpl.getFarmHouseListByUserId(userId);
	}
	
	
	@GetMapping("/dm/farmhouse/{farmhouseid}")
	@ResponseStatus(value = HttpStatus.OK)
	public FarmHouseDto findFarmHouseId(
			@PathVariable("farmhouseid") Long farmhouseid){
		log.info("getfarmhouseId by User ID :"+ farmhouseid);
		return this.farmHouseServiceImpl.getFarmHouseByFarmHouseId(farmhouseid);
	}
	
	
	@DeleteMapping("dm/farmhouse/delete/{farmhouseid}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String,String>> deleteByFarmhouseid(@PathVariable("farmhouseid") Long farmhouseid)
    {
		log.info("Delete Farmhouse By Farmhouse ID: Entry "+ farmhouseid);
		Map<String,String> responseMap=new HashMap<String,String>();
		try {
		
			responseMap=farmHouseServiceImpl.deleteFarmhouseById(farmhouseid);
	        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
		}
        catch(Exception e) {
        	responseMap.put("status", "Failed");
			responseMap.put("message", e.getMessage());
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        }
    }


}
