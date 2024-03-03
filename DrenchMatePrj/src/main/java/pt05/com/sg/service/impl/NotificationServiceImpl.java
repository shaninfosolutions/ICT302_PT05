package pt05.com.sg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.entity.Notification;
import pt05.com.sg.data.repository.NotificationRepository;
import pt05.com.sg.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService{
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	public List<Notification> getList() {
		return (List<Notification>) this.notificationRepository.findAll();
	}
	
	public Notification addOrUpdate(Notification notification) {
		return this.notificationRepository.save(notification);
	}

}
