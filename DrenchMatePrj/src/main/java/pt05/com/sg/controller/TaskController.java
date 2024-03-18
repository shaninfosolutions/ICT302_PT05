package pt05.com.sg.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pt05.com.sg.data.dto.FarmHouseDto;
import pt05.com.sg.data.dto.TaskDto;
import pt05.com.sg.data.repository.TaskRepository;
import pt05.com.sg.service.impl.TaskServiceImpl;
import pt05.com.sg.data.entity.Task;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class TaskController {
	
	private static final Logger log = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
	private TaskServiceImpl taskServiceImpl;
	
	
	@GetMapping("/dm/tasks/userid/{userId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<TaskDto>findAllTasks(@PathVariable("userId") Long userId) {
		log.info("Fina All Tasks by User ID :"+ userId);
    	 return this.taskServiceImpl.getList(userId);
	}
	
	
	@GetMapping("/dm/tasks/{taskId}")
	@ResponseStatus(value = HttpStatus.OK)
	public TaskDto findTaskById(
			@PathVariable("taskId") Long taskId){
		log.info("Get Task by Task ID :"+ taskId);
		//return this.farmHouseServiceImpl.getFarmHouseByFarmHouseId(farmhouseid);
		return this.taskServiceImpl.getTaskByTaskId(taskId);
	}
	
	
	

}
