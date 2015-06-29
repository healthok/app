package biz;

import java.util.ArrayList;
import java.util.Map;

public class Address {

	public static int sendAddress(model.Address object, String username){
		
		return dal.Address.insertAddress(object,username);
	}
	
	public static ArrayList<model.Address> getAddress(String username){
		
		return dal.Address.responseAddress(username);
	}
	public static void deleteAddress(int addressid){
		dal.Address.deleteAddress(addressid);
	}
	public static void updateAddress(model.Address object,int addressid){
		dal.Address.updateAddress(object, addressid);
	}
}
