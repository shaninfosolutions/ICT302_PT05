package pt05.com.sg.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotificationHelper {
	
	public static String replacePlaceholders( Map<String, String> replacements,String input) {
        // Define the regular expression pattern to match placeholders ($xxx$)
        Pattern pattern = Pattern.compile("\\$([^$]+)\\$");
        
        // Create a matcher for the input string
        Matcher matcher = pattern.matcher(input);

        // StringBuffer to hold the modified string
        StringBuffer sb = new StringBuffer();

        // Find and replace placeholders with corresponding values
        while (matcher.find()) {
            String placeholder = matcher.group(1); // Extract the placeholder (e.g., "name" or "zone")
            String replacement = replacements.getOrDefault(placeholder, ""); // Get replacement value or empty string if not found
            matcher.appendReplacement(sb, replacement); // Replace placeholder with corresponding value
        }

        // Append the remaining part of the input string
        matcher.appendTail(sb);

        // Return the modified string
        return sb.toString();
}

}
