package pt05.com.sg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:${user.dir}/licence/licence.properties")
public class LicenseConfiguration {

}
