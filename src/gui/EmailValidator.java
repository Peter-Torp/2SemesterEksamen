package gui;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	public static void checkEmail() {
		String email = "finn.nordb@jerg@gmail.com";
		String emailPattern = "^[a-<A-Z09._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,4}$";
		Pattern pattern = Pattern.compile(emailPattern);
		
		Matcher m = pattern.matcher(email);
		if(m.find())            
		    System.out.println(email + " is ok");        
		else            
			System.out.println(email + " is not ok");
	}
	
	
	    	    
	  
	
}
