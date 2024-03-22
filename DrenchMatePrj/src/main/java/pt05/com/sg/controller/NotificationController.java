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
import pt05.com.sg.data.dto.NotiTaskSummaryDto;
import pt05.com.sg.data.dto.NotificationNoteSummaryDto;
import pt05.com.sg.service.impl.NotificationServiceImpl;

@CrossOrigin(origins = "${spring.mvc.cors.allowed-origins}")
@RestController
@RequestMapping("api/v1")
public class NotificationController {
	private static final Logger log = LoggerFactory.getLogger(NotificationController.class);
	
	
	@Autowired 
	private NotificationServiceImpl notificationServiceImpl;
	
	@GetMapping("/dm/noti/note/{userId}")
	@ResponseStatus(value = HttpStatus.OK)
	public HashMap<String,List> findNoteNotiSeverityLevel(
			@PathVariable("userId") Long userId){
		log.info("Get Note Noti Severity Leavel by User ID :"+ userId);
		//return this.farmHouseServiceImpl.getFarmHouseByFarmHouseId(farmhouseid);
		return this.notificationServiceImpl.getNoteNotSeverityLevel(userId);
	}
	
	@GetMapping("/dm/noti/task/{userId}")
	@ResponseStatus(value = HttpStatus.OK)
	public HashMap<String,List> findTaskSchedular(
			@PathVariable("userId") Long userId){
		log.info("Get Task Schedular by User ID :"+ userId);
		//return this.farmHouseServiceImpl.getFarmHouseByFarmHouseId(farmhouseid);
		return this.notificationServiceImpl.getTaskSchedule(userId);
	}
	
	
	@GetMapping("/dm/noti/notesummary/{userId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<NotificationNoteSummaryDto> findNoteNotiSummary(
			@PathVariable("userId") Long userId){
		log.info("Get Note Noti Summary by User ID :"+ userId);
		//return this.farmHouseServiceImpl.getFarmHouseByFarmHouseId(farmhouseid);
		return this.notificationServiceImpl.getNotiNoteSummary(userId);
	}
	
	
	@GetMapping("/dm/noti/tasksummary/{userId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<NotiTaskSummaryDto> findTaskNotiSummary(
			@PathVariable("userId") Long userId){
		log.info("Get Task Noti Summary by User ID :"+ userId);
		//return this.farmHouseServiceImpl.getFarmHouseByFarmHouseId(farmhouseid);
		return this.notificationServiceImpl.getNotiTaskSummary(userId);
	}
	
	
	@PostMapping("/dm/noti/task/addorupdate")
	@ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Map<String,String>> addOrUpdateNotiTask
    	(@RequestHeader Map<String, String> headers,
    			@RequestBody NotiTaskSummaryDto notiTaskSummaryDto,
    			@RequestParam("userId") Long userId) {
		log.info("Update Noti Task: " + userId);
		
		try {
			Map<String,String> responseMap=this.notificationServiceImpl.addOrUpdateNotiTask(notiTaskSummaryDto, userId);
			return ResponseEntity.status(HttpStatus.OK).body(responseMap);
		 
		}catch(Exception e) {
			Map<String,String> responseMap=new HashMap<String,String>();
			responseMap.put("status", "Failed");
			responseMap.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
		}
	}
	
	
	@PostMapping("/dm/noti/note/addorupdate")
	@ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Map<String,String>> addOrUpdateNotiNote
    	(@RequestHeader Map<String, String> headers,
    			@RequestBody NotificationNoteSummaryDto notificationNoteSummaryDto,
    			@RequestParam("userId") Long userId) {
		log.info("Update Noti Note: " + userId);
		
		try {
			Map<String,String> responseMap=this.notificationServiceImpl.addOrUpdateNotiNote(notificationNoteSummaryDto, userId);
			return ResponseEntity.status(HttpStatus.OK).body(responseMap);
		 
		}catch(Exception e) {
			Map<String,String> responseMap=new HashMap<String,String>();
			responseMap.put("status", "Failed");
			responseMap.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
		}
	}
	
	
	
}
