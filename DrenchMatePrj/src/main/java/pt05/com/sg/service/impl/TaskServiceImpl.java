package pt05.com.sg.service.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.dto.TaskDto;
import pt05.com.sg.data.entity.FarmHouse;
import pt05.com.sg.data.entity.Task;
import pt05.com.sg.data.entity.User;
import pt05.com.sg.data.repository.FarmHouseRepository;
import pt05.com.sg.data.repository.TaskRepository;
import pt05.com.sg.data.repository.UserRepository;
import pt05.com.sg.service.TaskService;
import pt05.com.sg.util.TaskHelper;

@Service
public class TaskServiceImpl implements TaskService{
	private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

	@Autowired
	private  TaskRepository taskRepository;
	

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private FarmHouseRepository farmHouseRepository;
	
	public List<TaskDto> getList(Long userId) {
		//return (List<Task>) this.taskRepository.findAll();
		
		Optional<List<Task>> taskList=this.taskRepository.findByUserId(userId);
		List<TaskDto> taskDtolist=null;
		try {
			
			if(taskList.isPresent() && taskList!=null) {
				taskDtolist= new ArrayList<>();
				
				for(Task t: taskList.get()) {
					TaskDto dto = new TaskDto();
					dto.setTaskId(t.getTaskId());
					dto.setStartDate(TaskHelper.dateToStringDDMMMYYYY(t.getStartDate()));
					dto.setEndDate(TaskHelper.dateToStringDDMMMYYYY(t.getEndDate()));
					dto.setFarmHouseName(t.getFarmHouse().getFarmHouseName());
					dto.setTaskTitle(t.getTaskTitle());
					dto.setTaskType(t.getTaskType());
					dto.setStatus(t.getStatus());
					dto.setRemarks(t.getRemarks());
					dto.setFarmHouseId(t.getFarmHouse().getFarmHouseId());
					dto.setUserId(t.getUser().getUserId());
					
					taskDtolist.add(dto);
				}
				
			}else {
				taskDtolist=null;
			}
			
		}catch(Exception e) {
			log.info("System Exception");
		}
		
		return taskDtolist;
	}
	
	public TaskDto getTaskByTaskId(Long taskId) {
		
		Optional<Task> task=this.taskRepository.findByTaskId(taskId);
		TaskDto taskDto=null;
		try {
			
			if(task.isPresent() && task.get()!=null) {
				taskDto=TaskHelper.mapFarmHouseDto(task.get());
			}else {
				log.info("Task not exist in the System!!!!");
				taskDto=null;
			}
			
		}catch(Exception e) {
			log.info("System Exception");
		}
		
		return taskDto;
		
	}
	
	public Map<String,String> addOrUpdate(TaskDto task) {
		
		Map<String,String> responseMessage=new HashMap<String,String>();
		String message="";
		Optional<User> userOptional=this.userRepository.findByUserId(task.getUserId());
		Optional<FarmHouse> farmHouseOptional=this.farmHouseRepository.findByFarmHouseId(task.getFarmHouseId());
		
		log.info("Task: User ID: " +task.getUserId()+":"+task.getTaskId()+":"+farmHouseOptional.get().getFarmHouseId());
		try {
		if(userOptional.isPresent() && userOptional.get()!=null && task.getTaskId()==null && farmHouseOptional.get()!=null) {
			log.info("Task Creation: User ID: " +task.getUserId()+":"+task.getStartDate());
			User userDb=userOptional.get();
			FarmHouse fh=farmHouseOptional.get();
			Task taskDb=new Task();
			taskDb.setTaskTitle(task.getTaskTitle());
			taskDb.setStartDate(TaskHelper.stringToDateDDMMMYYYY(task.getStartDate()));
			taskDb.setEndDate(TaskHelper.stringToDateDDMMMYYYY(task.getEndDate()));
			taskDb.setTaskType("0");
			taskDb.setUser(userDb);
			taskDb.setFarmHouse(fh);
			taskDb.setCreatedBy(userDb.getName());
			taskDb.setCreatedDate(new Date());
			taskDb.setLastUpdatedBy(userDb.getName());
			taskDb.setLastUpdatedDate(new Date());
			taskDb.setRemarks(task.getRemarks());
			taskDb.setStatus(task.getStatus());
			
			Task saveTask=this.taskRepository.save(taskDb);
			
			if(saveTask!=null) {
				message="Task has been Added Successfully";
				responseMessage.put("status", "Success");
				responseMessage.put("message",message);
			}
		
			
		}else if (userOptional.isPresent() && userOptional.get()!=null && task.getTaskId()!=null && farmHouseOptional.get()!=null){
			
			Task taskDb=this.taskRepository.findByTaskId(task.getTaskId()).get();
			if(taskDb!=null) {
				log.info("Task Updating: User ID: " +task.getUserId() +":"+task.getTaskId());
				User userDb=userOptional.get();
				FarmHouse fh=farmHouseOptional.get();
				
				taskDb.setTaskTitle(task.getTaskTitle());
				taskDb.setStartDate(TaskHelper.stringToDateDDMMMYYYY(task.getStartDate()));
				taskDb.setEndDate(TaskHelper.stringToDateDDMMMYYYY(task.getEndDate()));
				taskDb.setStatus(task.getStatus());
				taskDb.setRemarks(task.getRemarks());
				taskDb.setLastUpdatedDate(new Date());
				taskDb.setLastUpdatedBy(userDb.getName());
				taskDb.setUser(userDb);
				taskDb.setFarmHouse(fh);
				
				Task saveTask=this.taskRepository.save(taskDb);
				
				if(saveTask!=null) {
					message="Task hased been Updated Successfully";
					responseMessage.put("status", "Success");
					responseMessage.put("message",message);
				}
			}
			
			
		}else {
			log.info("User not exist, Task cannot be creatd without a valid user");
			message="User must exist to create Task";
			responseMessage.put("status", "Failed");
			responseMessage.put("message",message);
		}
		}catch(Exception e) {
			log.info("Task Exception ");
			responseMessage.put("status", "Failed");
			message=e.getMessage();
			responseMessage.put("message",e.getMessage());
			
		}		
		return responseMessage;
	}
	
	public Map<String,String>  deleteTaskById(Long taskId){

		
		Optional<Task> taskOptional=this.taskRepository.findByTaskId(taskId);
		String message="";
		Map<String,String> responseMessage=new HashMap<String,String>();
		try {
			if(taskOptional.isPresent()) {
				
				this.taskRepository.delete(taskOptional.get());
				message="Deleted Task Successfully";
				responseMessage.put("status", "Success");
				responseMessage.put("message",message);
				
			}else {
				message="Task not exist to delete";
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
