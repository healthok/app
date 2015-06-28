package first;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
	public static Map<Long, Message> message=new HashMap<>();
	public static Map<Long, Profile> profile=new HashMap<>();
	public static Map<Long, Message> getMessage(){
		
		return message;
	}
	
	public static Map<Long, Profile> getProfile(){
		return profile;
	}

	
	
}
