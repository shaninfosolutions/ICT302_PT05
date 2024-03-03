package pt05.com.sg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.entity.Task;
import pt05.com.sg.data.repository.TaskRepository;
import pt05.com.sg.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private  TaskRepository taskRepository;
	
	public List<Task> getList() {
		return (List<Task>) this.taskRepository.findAll();
	}
	
	public Task addOrUpdate(Task task) {
		return this.taskRepository.save(task);
	}

}
