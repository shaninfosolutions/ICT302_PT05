package pt05.com.sg.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.dto.FarmHouseDto;
import pt05.com.sg.data.dto.TaskDto;
import pt05.com.sg.data.entity.Task;
import pt05.com.sg.data.repository.TaskRepository;
import pt05.com.sg.service.TaskService;
import pt05.com.sg.util.TaskHelper;

@Service
public class TaskServiceImpl implements TaskService{
	private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

	@Autowired
	private  TaskRepository taskRepository;
	
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
					dto.setTaskTitle(t.getTaskTitle());
					dto.setTaskType(t.getTaskType());
					dto.setRemarks(t.getRemarks());
					dto.setFarmhouseId(t.getFarmHouse().getFarmHouseId());
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
		
		Optional<Task> task=this.taskRepository.findById(taskId);
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
	
	public Task addOrUpdate(Task task) {
		return this.taskRepository.save(task);
	}

}
