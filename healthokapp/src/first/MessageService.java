package first;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class MessageService {
	
	private Map<Long, Message> messages=DatabaseClass.getMessage();
	public MessageService(){
		messages.put(1L,new Message(1,"Ghanshyam yadav","first element"));
		messages.put(2L,new Message(2,"Deobrat singh","second element"));
		messages.put(3L,new Message(3,"Ashish","third element"));
		messages.put(4L,new Message(4,"gaurav sing","forth element"));
		
	}
	
	public List<Message> getAllMessage(){
		return new ArrayList<Message>(messages.values());
	}
	public Message getMessage(Long id){
		return messages.get(id);

	}
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
			return message;
	}
	public Message removeMessgae(Long id){
		
		return messages.remove(id);
		
	}

}
