package pt05.com.sg.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pt05.com.sg.data.entity.NotificationSetting;
@Repository
public interface NotificationSettingRepository extends CrudRepository<NotificationSetting, Long>{

}
