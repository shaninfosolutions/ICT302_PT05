package pt05.com.sg.service;

import java.util.List;

import pt05.com.sg.data.entity.Notification;

public interface NotificationService {
	
	public List<Notification> getList();
	
	public Notification addOrUpdate(Notification notification);
	
	public void processNotification();
	
	public void processTaskNotification();

}
