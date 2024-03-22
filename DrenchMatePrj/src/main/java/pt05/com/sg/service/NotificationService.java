package pt05.com.sg.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import pt05.com.sg.data.dto.NotiNoteSeverifyLevelDto;
import pt05.com.sg.data.dto.NotiTaskSummaryDto;
import pt05.com.sg.data.dto.NotificationNoteSummaryDto;
import pt05.com.sg.data.entity.Notification;

public interface NotificationService {
	
	public List<Notification> getList();
	
	public Notification addOrUpdate(Notification notification);
	
	public void processNotification();
	
	public void processTaskNotification();
	
	public HashMap<String,List> getNoteNotSeverityLevel(Long userId);
	
	public HashMap<String,List> getTaskSchedule(Long userId);

	public List<NotiTaskSummaryDto> getNotiTaskSummary(Long userId);
	
	public List<NotificationNoteSummaryDto> getNotiNoteSummary(Long userId) ;
	
	public Map<String,String> addOrUpdateNotiTask(NotiTaskSummaryDto notiTaskSummaryDto,Long userId);
	
	public Map<String,String> addOrUpdateNotiNote(NotificationNoteSummaryDto notiTaskSummaryDto,Long userId);

}
