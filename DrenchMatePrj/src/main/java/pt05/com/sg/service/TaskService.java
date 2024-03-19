package pt05.com.sg.service;

import java.util.List;
import java.util.Map;

import pt05.com.sg.data.dto.TaskDto;
import pt05.com.sg.data.entity.Task;

public interface TaskService {
	
	public List<TaskDto> getList(Long userId);
	
	public TaskDto getTaskByTaskId(Long taskId);
	
	public Map<String,String> addOrUpdate(TaskDto task);
	
	public Map<String,String>  deleteTaskById(Long taskId);

}
