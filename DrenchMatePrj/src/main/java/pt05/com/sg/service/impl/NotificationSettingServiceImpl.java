package pt05.com.sg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.entity.NotificationSetting;
import pt05.com.sg.data.repository.NotificationSettingRepository;
import pt05.com.sg.service.NotificationSettingService;

@Service
public class NotificationSettingServiceImpl implements NotificationSettingService{

	@Autowired
	private NotificationSettingRepository notificationSettingRepository;
	
	public List<NotificationSetting> getList() {
		return (List<NotificationSetting>) this.notificationSettingRepository.findAll();
	}
	
	public NotificationSetting addOrUpdate(NotificationSetting notificationSetting) {
		return this.notificationSettingRepository.save(notificationSetting);
	}
	
}
