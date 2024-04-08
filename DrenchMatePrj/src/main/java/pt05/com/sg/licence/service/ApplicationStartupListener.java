package pt05.com.sg.licence.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupListener {
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationStartupListener.class);
	
	
	@Autowired
    private LicenseValidationService licenseValidationService;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReadyEvent() {
        if (licenseValidationService.isLicenseValid()) {
        	log.info("License is valid for " + licenseValidationService.getIssuedTo());
        } else {
        	log.info("License validation failed. Application will not start.");
            System.exit(-1);
        }
    }

}
