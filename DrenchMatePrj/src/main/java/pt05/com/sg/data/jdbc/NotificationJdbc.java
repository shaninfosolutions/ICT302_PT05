package pt05.com.sg.data.jdbc;

import java.util.List;
import pt05.com.sg.data.dto.EligibleUsersToNotifyDto;
import pt05.com.sg.data.dto.NotiNoteSeverifyLevelDto;
import pt05.com.sg.data.dto.NotiRuleScoreCard;
import pt05.com.sg.data.dto.NotiTaskSummaryDto;
import pt05.com.sg.data.dto.NotificationNoteSummaryDto;
public interface NotificationJdbc {
	
	public List<EligibleUsersToNotifyDto> findEligibleUsersToNotify(Long cutOfDaysOne) ;
	
	public List<EligibleUsersToNotifyDto> findEligibleTaskNotify(Long cutOfDaysOne);
	    
	public Long  findUserNotiScoreCard(Long cutOfDaysOne,
			Long userId,
			Long farmHouseId);
	
	public Long findNotiRuleScoreCard();
	
	public List<NotiNoteSeverifyLevelDto> findNoteNotiSeverityLevel(Long userId,String notiType) ;
	
	public List<NotiNoteSeverifyLevelDto> findTaskSchedule(Long userId,String notiType);
	
	public List<NotificationNoteSummaryDto> findNotiNoteSummary(Long userId);
	
	public List<NotiTaskSummaryDto> findNotiTaskSummary(Long userId);
}
