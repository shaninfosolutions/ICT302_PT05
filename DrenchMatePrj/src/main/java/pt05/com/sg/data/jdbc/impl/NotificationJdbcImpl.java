package pt05.com.sg.data.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pt05.com.sg.data.dto.EligibleUsersToNotifyDto;
import pt05.com.sg.data.dto.NotiRuleScoreCard;
import pt05.com.sg.data.jdbc.NotificationJdbc;


@Repository
public class NotificationJdbcImpl implements NotificationJdbc {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	public List<EligibleUsersToNotifyDto> findEligibleUsersToNotify(Long cutOfDaysOne) {
	    return jdbcTemplate.query(
	        "SELECT U.USERID,U.NAME, NOTE.FARMHOUSEID,NOTISETTING.EMAIL " +
	        "FROM TB_USER U, TB_NOTE NOTE, TB_USER_NOTE_RULE USERNOTE, TB_NOTIFICATION_SETTING NOTISETTING " +
	        "WHERE NOTE.NOTEID = USERNOTE.NOTEID " +
	        "AND NOTE.USERID = U.USERID AND NOTISETTING.USERID=U.USERID AND NOTISETTING.TORECEIVENOTIFICATION='Y' " +
	        "AND TO_NUMBER(TO_CHAR(NOTE.CREATEDDATE,'YYYYMMDD')) <= TO_NUMBER(TO_CHAR(SYSDATE - ?,'YYYYMMDD')) " +
	        "AND TO_NUMBER(TO_CHAR(NOTE.CREATEDDATE,'YYYYMMDD')) >= TO_NUMBER(TO_CHAR(SYSDATE - NOTISETTING.NOOFDAYS,'YYYYMMDD')) " +
	        "AND NOT EXISTS (SELECT 1 FROM TB_NOTIFICATION NOTI " +
	        "                WHERE NOTI.USERID = U.USERID AND NOTI.FARMHOUSEID= NOTE.FARMHOUSEID AND NOTI.NOTITYPE='USER_NOTE' " +
	        "                AND TO_NUMBER(TO_CHAR(NOTI.DATEOFNOTIFICATION,'YYYYMMDD')) = TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD'))) " +
	        "GROUP BY U.USERID, NOTE.FARMHOUSEID,NOTISETTING.EMAIL,U.NAME ",
	        new Object[]{cutOfDaysOne},
	        new BeanPropertyRowMapper<>(EligibleUsersToNotifyDto.class)
	    );
	}
	
	
	@SuppressWarnings("unchecked")
	public List<EligibleUsersToNotifyDto> findEligibleTaskNotify(Long cutOfDaysOne) {
	    return jdbcTemplate.query(
	        "SELECT U.USERID,U.NAME, TASK.FARMHOUSEID,NOTISETTING.EMAIL\r\n"
	        + "FROM TB_USER U, TB_TASK TASK, TB_NOTIFICATION_SETTING NOTISETTING  \r\n"
	        + "WHERE TASK.USERID = U.USERID AND NOTISETTING.USERID=U.USERID AND NOTISETTING.TORECEIVENOTIFICATION='Y'  \r\n"
	        + "AND TO_NUMBER(TO_CHAR(TASK.StartDate,'YYYYMMDD')) <= TO_NUMBER(TO_CHAR(SYSDATE - ?,'YYYYMMDD'))  \r\n"
	        + "AND TO_NUMBER(TO_CHAR(TASK.StartDate,'YYYYMMDD')) >= TO_NUMBER(TO_CHAR(SYSDATE - NOTISETTING.NOOFDAYS,'YYYYMMDD'))  \r\n"
	        + "AND NOT EXISTS (SELECT 1 FROM TB_NOTIFICATION NOTI  \r\n"
	        + "WHERE NOTI.USERID = U.USERID AND NOTI.FARMHOUSEID= TASK.FARMHOUSEID  \r\n"
	        + "AND NOTI.NOTITYPE='USER_TASK'\r\n"
	        + "AND TO_NUMBER(TO_CHAR(NOTI.DATEOFNOTIFICATION,'YYYYMMDD')) = TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')))  \r\n"
	        + "GROUP BY U.USERID, TASK.FARMHOUSEID,NOTISETTING.EMAIL,U.NAME,TASK.TaskId ",
	        new Object[]{cutOfDaysOne},
	        new BeanPropertyRowMapper<>(EligibleUsersToNotifyDto.class)
	    );
	}
	
	
	
	public Long findUserNotiScoreCard(Long cutOfDaysOne,
            Long userId,
            Long farmHouseId) {
			return jdbcTemplate.queryForObject(
			"SELECT ROUND(SUM(TT.SCORE)/SUM(TT.ROWCOUNT)) AS SCORE FROM(" +
			"SELECT SUM(USERNOTE.RULEVALUE) AS SCORE, " +
			"COUNT(NOTE.NOTEID) OVER(PARTITION BY NOTE.NOTEID) AS ROWCOUNT " +
			"FROM TB_USER U, TB_NOTE NOTE, TB_USER_NOTE_RULE USERNOTE, TB_NOTIFICATION_SETTING NOTISETTING " +
			"WHERE NOTE.NOTEID = USERNOTE.NOTEID " +
			"AND NOTE.USERID = U.USERID AND NOTISETTING.TORECEIVENOTIFICATION='Y' " +
			"AND TO_NUMBER(TO_CHAR(NOTE.CREATEDDATE, 'YYYYMMDD')) <= TO_NUMBER(TO_CHAR(SYSDATE - ?, 'YYYYMMDD')) " +
			"AND TO_NUMBER(TO_CHAR(NOTE.CREATEDDATE, 'YYYYMMDD')) >= TO_NUMBER(TO_CHAR(SYSDATE - NOTISETTING.NOOFDAYS, 'YYYYMMDD')) " +
			"AND U.USERID = ? AND NOTE.FARMHOUSEID = ? " +
			"AND NOT EXISTS (SELECT 1 FROM TB_NOTIFICATION NOTI " +
			"WHERE NOTI.USERID = U.USERID AND NOTI.FARMHOUSEID = NOTE.FARMHOUSEID " +
			"AND NOTI.NOTITYPE='USER_NOTE'\r\n" +
			"AND TO_NUMBER(TO_CHAR(NOTI.DATEOFNOTIFICATION, 'YYYYMMDD')) = TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMMDD'))) " +
			"GROUP BY U.USERID, NOTE.FARMHOUSEID, NOTE.NOTEID) TT ",
			new Object[]{cutOfDaysOne, userId, farmHouseId},
			Long.class
				);
	}

	
	@SuppressWarnings("unchecked")
	public Long findNotiRuleScoreCard() {
	    return jdbcTemplate.queryForObject(
	        "SELECT SUM(TT.BEST) AS bestScore FROM (SELECT MAX(CODEVALUE) AS BEST, MIN(CODEVALUE) AS WORST FROM TB_RULE_CODE_VALUE GROUP BY RULECODEID) TT ",
	        Long.class
	    );
	}

}
