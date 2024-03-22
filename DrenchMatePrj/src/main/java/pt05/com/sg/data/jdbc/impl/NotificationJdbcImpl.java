package pt05.com.sg.data.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pt05.com.sg.data.dto.EligibleUsersToNotifyDto;
import pt05.com.sg.data.dto.NotiNoteSeverifyLevelDto;
import pt05.com.sg.data.dto.NotiRuleScoreCard;
import pt05.com.sg.data.jdbc.NotificationJdbc;
import pt05.com.sg.data.dto.NotificationNoteSummaryDto;
import pt05.com.sg.data.dto.NotiTaskSummaryDto;


@Repository
public class NotificationJdbcImpl implements NotificationJdbc {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	public List<EligibleUsersToNotifyDto> findEligibleUsersToNotify(Long cutOfDaysOne) {
	    return jdbcTemplate.query(
	        "SELECT U.USERID,U.NAME, NOTE.FARMHOUSEID,NOTISETTING.EMAIL,NULL AS TASKID, NOTE.NOTEID " +
	        "FROM TB_USER U, TB_NOTE NOTE, TB_USER_NOTE_RULE USERNOTE, TB_NOTIFICATION_SETTING NOTISETTING " +
	        "WHERE NOTE.NOTEID = USERNOTE.NOTEID " +
	        "AND NOTE.USERID = U.USERID AND NOTISETTING.USERID=U.USERID AND NOTISETTING.TORECEIVENOTIFICATION='Y' AND NOTISETTING.USERID=U.USERID " +
	        "AND TO_NUMBER(TO_CHAR(NOTE.CREATEDDATE,'YYYYMMDD')) <= TO_NUMBER(TO_CHAR(SYSDATE - ?,'YYYYMMDD')) " +
	        "AND TO_NUMBER(TO_CHAR(NOTE.CREATEDDATE,'YYYYMMDD')) >= TO_NUMBER(TO_CHAR(SYSDATE - NOTISETTING.NOOFDAYS,'YYYYMMDD')) " +
	        "AND NOT EXISTS (SELECT 1 FROM TB_NOTIFICATION NOTI " +
	        "                WHERE NOTI.USERID = U.USERID AND NOTI.FARMHOUSEID= NOTE.FARMHOUSEID AND NOTI.NOTITYPE='USER_NOTE'  AND NOTI.NoteId=Note.NoteId " +
	        "                AND TO_NUMBER(TO_CHAR(NOTI.DATEOFNOTIFICATION,'YYYYMMDD')) = TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD'))) " +
	        "GROUP BY U.USERID, NOTE.FARMHOUSEID,NOTISETTING.EMAIL,U.NAME ,NOTE.NOTEID ",
	        new Object[]{cutOfDaysOne},
	        new BeanPropertyRowMapper<>(EligibleUsersToNotifyDto.class)
	    );
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<EligibleUsersToNotifyDto> findEligibleTaskNotify(Long cutOfDaysOne) {
	    return jdbcTemplate.query(
	        "SELECT U.USERID,U.NAME, TASK.FARMHOUSEID,NOTISETTING.EMAIL,TASK.TASKID, NULL AS NOTEID\r\n"
	        + "FROM TB_USER U, TB_TASK TASK, TB_NOTIFICATION_SETTING NOTISETTING  \r\n"
	        + "WHERE TASK.USERID = U.USERID AND NOTISETTING.USERID=U.USERID AND NOTISETTING.TORECEIVENOTIFICATION='Y' AND NOTISETTING.USERID=U.USERID  \r\n"
	       // + "AND TO_NUMBER(TO_CHAR(TASK.StartDate ,'YYYYMMDD')) <= TO_NUMBER(TO_CHAR(SYSDATE - ?,'YYYYMMDD'))  \r\n"
	        + "AND (TO_NUMBER(TO_CHAR(SYSDATE - NOTISETTING.NOOFDAYS,'YYYYMMDD'))  <= TO_NUMBER(TO_CHAR(TASK.StartDate,'YYYYMMDD')) "
	        + "or TO_NUMBER(TO_CHAR(SYSDATE - ?,'YYYYMMDD')) =TO_NUMBER(TO_CHAR(TASK.StartDate,'YYYYMMDD')))  \r\n"
	        + "AND NOT EXISTS (SELECT 1 FROM TB_NOTIFICATION NOTI  \r\n"
	        + "WHERE NOTI.USERID = U.USERID AND NOTI.FARMHOUSEID= TASK.FARMHOUSEID  \r\n"
	        + "AND NOTI.NOTITYPE='USER_TASK'  AND NOTI.TASKID=TASK.TASKID \r\n"
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
			"AND NOTE.USERID = U.USERID AND NOTISETTING.TORECEIVENOTIFICATION='Y' AND NOTISETTING.USERID=U.USERID " +
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




	@Override
	public List<NotiNoteSeverifyLevelDto> findNoteNotiSeverityLevel(Long userId,String notiType) {
		return (List<NotiNoteSeverifyLevelDto>) jdbcTemplate.query(
		        "select count(tt.labelNotiValue) as notiValue,labelNotiValue,tt.backgroundColor from\r\n"
		        + "(select \r\n"
		        + "case when TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')) - TO_NUMBER(TO_CHAR(NOTI.DATEOFNOTIFICATION,'YYYYMMDD')) =0 then 'S3'\r\n"
		        + "when TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')) - TO_NUMBER(TO_CHAR(NOTI.DATEOFNOTIFICATION,'YYYYMMDD')) =1 then 'S2'\r\n"
		        + "else 'S1' end as labelNotiValue,\r\n"
		        + "case when TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')) - TO_NUMBER(TO_CHAR(NOTI.DATEOFNOTIFICATION,'YYYYMMDD')) =0 then 'yellow'\r\n"
		        + "when TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')) - TO_NUMBER(TO_CHAR(NOTI.DATEOFNOTIFICATION,'YYYYMMDD')) =1 then 'green'\r\n"
		        + "else 'red' end as backgroundColor,\r\n"
		        + "noti.* from tb_notification noti where noti.userid=? and noti.notitype=?"
		        + "and noti.status='OPEN' ) tt group by labelNotiValue,tt.backgroundColor ",
		        new Object[]{userId,notiType},
		        new BeanPropertyRowMapper<>(NotiNoteSeverifyLevelDto.class)
		    );
	}
	
	
	@Override
	public List<NotiNoteSeverifyLevelDto> findTaskSchedule(Long userId,String notiType) {
		return (List<NotiNoteSeverifyLevelDto>) jdbcTemplate.query(
		        "select count(tt.labelNotiValue) as notiValue,labelNotiValue,tt.backgroundColor from\r\n"
		        + "(select case when TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')) - TO_NUMBER(TO_CHAR(task.STARTDATE,'YYYYMMDD')) <0 then 'DUE'\r\n"
		        + "when TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')) - TO_NUMBER(TO_CHAR(task.STARTDATE,'YYYYMMDD')) =0 then 'ON TIME'\r\n"
		        + "else 'OVER DUE' end as labelNotiValue,\r\n"
		        + "case when TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')) - TO_NUMBER(TO_CHAR(task.STARTDATE,'YYYYMMDD')) <0 then 'yellow'\r\n"
		        + "when TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')) - TO_NUMBER(TO_CHAR(task.STARTDATE,'YYYYMMDD')) =0 then 'green'\r\n"
		        + "else 'red' end as backgroundColor,\r\n"
		        + "noti.* from tb_notification noti \r\n"
		        + "inner join tb_task task on task.taskid=noti.taskid where noti.userid=? and noti.notitype=? \r\n"
		        + "and noti.status='OPEN') tt group by labelNotiValue,tt.backgroundColor ",
		        new Object[]{userId,notiType},
		        new BeanPropertyRowMapper<>(NotiNoteSeverifyLevelDto.class)
		    );
	}
	
	
	@Override
	public List<NotificationNoteSummaryDto> findNotiNoteSummary(Long userId) {
		return (List<NotificationNoteSummaryDto>) jdbcTemplate.query(
		        "select \r\n"
		        + "noti.NOTIFICATIONID,\r\n"
		        + "u.name,\r\n"
		        + "fh.farmhousename,\r\n"
		        + "n.notetitle,\r\n"
		        + "noti.message,\r\n"
		        + "noti.notitype,\r\n"
		        + "noti.status,\r\n"
		        + "(select sum(rulevalue) from tb_user_note_rule noterule where noterule.noteid=n.noteid) as score,\r\n"
		        + "noti.remarks,\r\n"
		        + "to_char(noti.dateofnotification,'DD/MM/YYYY') as  dateofnotification\r\n"
		        + " from \r\n"
		        + "tb_user u,\r\n"
		        + "tb_notification noti,\r\n"
		        + "tb_farm_house fh,\r\n"
		        + "tb_note n\r\n"
		        + "where u.userid=? and noti.notitype='USER_NOTE'\r\n"
		        + "and u.userid=noti.userid and fh.farmhouseid=noti.farmhouseid\r\n"
		        + "and n.noteid=noti.NOTEID and noti.status='OPEN' ",
		        new Object[]{userId},
		        new BeanPropertyRowMapper<>(NotificationNoteSummaryDto.class)
		    );
	}
	
	
	@Override
	public List<NotiTaskSummaryDto> findNotiTaskSummary(Long userId) {
		return (List<NotiTaskSummaryDto>) jdbcTemplate.query(
		        "select \r\n"
		        + "noti.NOTIFICATIONID,\r\n"
		        + "u.name,\r\n"
		        + "fh.farmhousename,\r\n"
		        + "t.TaskTitle,\r\n"
		        + "noti.message,\r\n"
		        + "noti.notitype,\r\n"
		        + "noti.status,\r\n"
		        + "to_char(t.StartDate,'DD/MM/YYYY') as StartDate,\r\n"
		        + "to_char(t.EndDate,'DD/MM/YYYY')  as EndDate,\r\n"
		        + " case when TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')) - TO_NUMBER(TO_CHAR(t.STARTDATE,'YYYYMMDD')) <0 then 'DUE'\r\n"
		        + "when TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')) - TO_NUMBER(TO_CHAR(t.STARTDATE,'YYYYMMDD')) =0 then 'ON TIME'\r\n"
		        + "else 'OVER DUE' end as labeldue,\r\n"
		        + "noti.remarks,\r\n"
		        + "to_char(noti.dateofnotification,'DD/MM/YYYY') as  dateofnotification\r\n"
		        + " from \r\n"
		        + "tb_user u,\r\n"
		        + "tb_notification noti,\r\n"
		        + "tb_farm_house fh,\r\n"
		        + "tb_task t\r\n"
		        + "where u.userid=? and noti.notitype='USER_TASK'\r\n"
		        + "and u.userid=noti.userid and fh.farmhouseid=noti.farmhouseid\r\n"
		        + "and t.TaskId=noti.TaskId and noti.status='OPEN' ",
		        new Object[]{userId},
		        new BeanPropertyRowMapper<>(NotiTaskSummaryDto.class)
		    );
	}

}
