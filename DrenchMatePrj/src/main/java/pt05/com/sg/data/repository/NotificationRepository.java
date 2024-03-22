package pt05.com.sg.data.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pt05.com.sg.data.entity.Notification;


@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long>{
	
	Optional<Notification> findByNotificationId(Long notificationId);
	
}
