package pt05.com.sg.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt05.com.sg.data.dto.TaskDto;
import pt05.com.sg.data.entity.Task;
import pt05.com.sg.service.impl.UserServiceImpl;

public class TaskHelper {
	private static final Logger log = LoggerFactory.getLogger(TaskHelper.class);
	
	public static TaskDto mapFarmHouseDto(Task t) {
		TaskDto dto = new TaskDto();
		dto.setTaskId(t.getTaskId());
		dto.setFarmHouseName(t.getFarmHouse().getFarmHouseName());
		dto.setStartDate(TaskHelper.dateToStringDDMMMYYYY(t.getStartDate()));
		dto.setEndDate(TaskHelper.dateToStringDDMMMYYYY(t.getEndDate()));
		dto.setTaskTitle(t.getTaskTitle());
		dto.setTaskType(t.getTaskType());
		dto.setRemarks(t.getRemarks());
		dto.setStatus(t.getStatus());
		dto.setFarmHouseId(t.getFarmHouse().getFarmHouseId());
		dto.setUserId(t.getUser().getUserId());
		
		return dto;
	}

	public static String dateToStringDDMMMYYYY(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if(date!=null) {
			return sdf.format(date);
		}else {
			log.info("Date is Null, return the current Date");
			return sdf.format(new Date());
		}
	}
	
	public static Date stringToDateDDMMMYYYY(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            // Parse the string into a Date object
        Date date;
		try {
				date = sdf.parse(dateString);
				return date;
		} catch (ParseException e) {
			log.info("Invalid Date (String to Date conversion failed)");
		}
		return null;
	}

}
