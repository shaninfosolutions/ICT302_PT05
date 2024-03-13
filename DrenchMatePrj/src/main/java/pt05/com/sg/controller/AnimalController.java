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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pt05.com.sg.data.dto.AnimalDto;
import pt05.com.sg.data.dto.FarmHouseDto;
import pt05.com.sg.service.impl.AnimalServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class AnimalController {
	
	private static final Logger log = LoggerFactory.getLogger(AnimalController.class);
	
	@Autowired
    private AnimalServiceImpl animalServiceImpl;
	
	@GetMapping("/dm/animal/{animalid}")
	public AnimalDto findAnimalsByAnimalId(
			@PathVariable("animalid") Long animalid) {
    	 return this.animalServiceImpl.findAnimalByAnimalId(animalid);
	}
	
	@GetMapping("/dm/animals/{farmhouseId}")
	public List<AnimalDto> findAllAnimalByFarmHouseId(
			@PathVariable("farmhouseId") Long farmhouseId) {
		
    	 return this.animalServiceImpl.findAnimalsByFarmHouseId(farmhouseId);
	}
	
	@PostMapping("/dm/animal/add")
	@ResponseStatus(value = HttpStatus.CREATED)
	 public ResponseEntity<Map<String,String>> addNewAnimal
 	(@RequestHeader Map<String, String> headers,@RequestBody AnimalDto animalDto) {
		
		log.info("Add Animal By : Entry "+ animalDto.getName());
		try {
			Map<String,String> responseMap=this.animalServiceImpl.addOrUpdate(animalDto);
			return ResponseEntity.status(HttpStatus.OK).body(responseMap);
		 
		}catch(Exception e) {
			Map<String,String> responseMap=new HashMap<String,String>();
			responseMap.put("status", "Failed");
			responseMap.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
		}
	}
	
	@DeleteMapping("dm/animal/delete/{animalId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String,String>> deleteByFarmhouseid(@PathVariable("animalId") Long animalId)
    {
		log.info("Delete Animal By Animal ID: Entry "+ animalId);
		Map<String,String> responseMap=new HashMap<String,String>();
		try {
		
			responseMap=this.animalServiceImpl.deleteAnimalById(animalId);
	        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
		}
        catch(Exception e) {
        	responseMap.put("status", "Failed");
			responseMap.put("message", e.getMessage());
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        }
    }
	
	
}
