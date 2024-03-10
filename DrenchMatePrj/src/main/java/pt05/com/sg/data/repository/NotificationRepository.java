package pt05.com.sg.data.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pt05.com.sg.data.dto.EligibleUsersToNotifyDto;
import pt05.com.sg.data.entity.Notification;
@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long>{
	
}
