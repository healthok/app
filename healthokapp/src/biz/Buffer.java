package biz;

import java.util.ArrayList;
import java.util.Map;

public class Buffer {

	public static int sendtoBuffer(String username,int medicineid,int quantity){
		
		return dal.Buffer.addtoBuffer(username, medicineid, quantity);
	}
	
	public static int sendDeleteBuffer(String username,int medicineid){
		return dal.Buffer.deleteBuffer(username, medicineid);
	}
	
	public static ArrayList<model.Medicine> getCartItems(String username){
		
		return dal.Buffer.getCartItems(username);
	}
}
