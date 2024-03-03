package pt05.com.sg.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerValidation {
	
	private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

	
	public static boolean isMandatory(String message,String value) {
		boolean result=true;
		if(value.isEmpty() && value.trim().isBlank()) {
			message="It is Mandatory";
			result=false;
		}
		return result;
	}
	
	private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
	
	public static boolean isValidEmail(Object message,String value) {
		boolean result=true;
		if(!isValidEmail(value)) {
			message="Invalid email address";
			result=false;
		}
		
		return result;
		
		
	}
	

}
