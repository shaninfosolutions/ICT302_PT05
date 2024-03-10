package pt05.com.sg.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class TaskSchedulerConfig {
	
	@Value("${spring.task.scheduling.pool.size}")
	private int poolSize;
	
	@Bean @Qualifier("mySchedulerUserNote")
    public TaskScheduler taskScheduler1() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(poolSize);
        scheduler.setThreadNamePrefix("MyTaskScheduler-UserNote-");
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        return scheduler;
    }
	
	@Bean @Qualifier("mySchedulerTask")
    public TaskScheduler taskScheduler2() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(poolSize);
        scheduler.setThreadNamePrefix("MyTaskScheduler-Task-");
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        return scheduler;
    }
	

}
