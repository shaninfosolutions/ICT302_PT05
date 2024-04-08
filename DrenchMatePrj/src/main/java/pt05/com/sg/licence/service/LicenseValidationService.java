package pt05.com.sg.licence.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mmk.com.sg.aes.LicenseKeyManager;

@Service
public class LicenseValidationService {
	
	private static final Logger log = LoggerFactory.getLogger(LicenseValidationService.class);
	
	
		@Value("${license.key}")
	    private String licenseKey;
	
		@Value("${license.userEmail}")
		private String userEmail;

	    @Value("${license.expiration.date}")
	    private String expirationDate;
	    
	    
	    @Value("${license.org}")
	    private String org;
	    
	    
	    @Value("${license.country}")
	    private String country;
	   

	    @Value("${license.issued.to}")
	    private String issuedTo;
	    
	    @Value("${license.issued.from}")
	    private String issuedFrom;

	    public boolean isLicenseValid() {
	        // Perform license validation logic here
	    	
	    	log.info("##################################################################");
	    	log.info("########               Validate Licence            ################");
	    	log.info("##################################################################");
	    	
	        boolean isExpired=false;
	        
	        boolean isLicenceValid=false;
	        
	        isExpired=LicenseKeyManager.isDateExpired(expirationDate);
	        
	        //generateLicenseKey(userEmail, expirationDate,org,country,issueTo,issueFrom);
	        //validateLicenseKey(licenseKey, userEmail, expirationDate,org,country,issueTo,issueFrom);
	        
	        isLicenceValid=LicenseKeyManager.
	        		validateLicenseKey(licenseKey, 
			        				userEmail, 
			        				expirationDate, 
			        				org, country, 
			        				issuedTo, issuedFrom);
	        
	        if(isExpired) log.info("The Licence is Expired, Please conduct the Licence Issuer to issue a new Licence:"+isExpired);
	        else log.info("Is not expired:"+isExpired);
	        if(isLicenceValid) log.info("Valid Licence:"+isLicenceValid);
	        else log.info("Invalid Licence,Please conduct the Licence Issuer to issue a new Licence:"+isLicenceValid);
	        
	        if(isExpired) return false;
	        else if(!isLicenceValid) return false;
	        else return true;
	        
	        //return (!isExpired && isLicenceValid);
	        
	    }

	    public String getIssuedTo() {
	        return issuedTo;
	    }

}
