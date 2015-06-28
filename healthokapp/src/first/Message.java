package first;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private long id;
	private String auther;
	private String message;
	
	 public Message() {
		
	}
	public Message(long id, String auther, String message) {
		super();
		this.id = id;
		this.auther = auther;
		this.message = message;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
