package pt05.com.sg.data.jdbc;

import java.util.List;
import pt05.com.sg.data.dto.EligibleUsersToNotifyDto;
import pt05.com.sg.data.dto.NotiRuleScoreCard;
public interface NotificationJdbc {
	
	public List<EligibleUsersToNotifyDto> findEligibleUsersToNotify(Long cutOfDaysOne) ;
	    
	public Long  findUserNotiScoreCard(Long cutOfDaysOne,
			Long userId,
			Long farmHouseId);
	
	public Long findNotiRuleScoreCard();
}
