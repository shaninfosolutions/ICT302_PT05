package pt05.com.sg.service;

import java.util.List;

import pt05.com.sg.data.dto.TaskDto;

public interface TaskService {
	
	public List<TaskDto> getList(Long userId);
	
	public TaskDto getTaskByTaskId(Long taskId);

}
